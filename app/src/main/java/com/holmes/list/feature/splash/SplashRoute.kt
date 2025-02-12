package com.holmes.list.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.holmes.list.R
import com.holmes.list.extension.clickableNoRipple
import com.holmes.list.ui.theme.ListTheme
import com.holmes.list.util.SuperDateUtil

/**
 * 启动页路由
 */
@Composable
fun SplashRoute(
    toMain: () -> Unit,
    viewModel: SplashViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val timeLeft by viewModel.timeLeft.collectAsStateWithLifecycle()
    val navigateToMain by viewModel.navigateToMain.collectAsState()

    SplashScreen(
        year = SuperDateUtil.currentYear(), timeLeft = timeLeft, toMain = toMain
    )

    if (navigateToMain) {
        LaunchedEffect(key1 = true) {
            toMain()
        }
    }
}

/**
 * 启动页函数
 */
@Composable
fun SplashScreen(
    year: Int = 2024,
    timeLeft: Long = 0,
    toMain: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Column {
            //Splash倒计时

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(10.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Text(
                    text = "$timeLeft s",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.labelSmall,
                )
            }

            //启动页应用名icon
            Column(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(120.dp)
                    .clickableNoRipple {
                        toMain()
                    }
            ) {
                Text(text = stringResource(id = R.string.app_name),
                    color = MaterialTheme.colorScheme.background,
                    style = MaterialTheme.typography.displayLarge
                )

                Box(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Image(
                        painter = painterResource(id = R.mipmap.todo_icon),
                        contentDescription = null,
                        modifier = Modifier.size(100.dp)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.BottomCenter
            ) {
                Column(
                    modifier = Modifier
                        .padding(bottom = 30.dp)
                ) {
                    Text(text = "by\n" + stringResource(id = R.string.author),
                        color = MaterialTheme.colorScheme.background,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier
                            .statusBarsPadding()
                            .padding(bottom = 70.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    // 启动页底部应用slogan
                    Text(
                        text = stringResource(id = R.string.app_slogan),
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier
                            .padding(bottom = 30.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    // 版权文件
                    Text(
                        text = stringResource(id = R.string.copyright, year),
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

/**
 * 启动页预览函数
 */
@Preview
@Composable
private fun SplashScreenPreview(): Unit {
    ListTheme {
        SplashScreen(2025)
    }
}