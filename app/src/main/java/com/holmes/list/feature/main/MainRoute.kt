package com.holmes.list.feature.main

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.holmes.list.component.MyNavigationBar
import com.holmes.list.feature.habit.HabitRoute
import com.holmes.list.feature.list.ListRoute
import com.holmes.list.feature.mine.MineRoute
import com.holmes.list.feature.week.WeekRoute
import com.holmes.list.ui.theme.ListTheme
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainRoute() {
    MainScreen()
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen() {
    //当前选中的界面名称
    var currentDestination by rememberSaveable {
        mutableStateOf(TopLevelDestination.LIST.route)
    }

    val pagerState = rememberPagerState { 4 }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HorizontalPager(
            state = pagerState,
            userScrollEnabled = false, //允许用户进行页面滑动
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {page->
            when(page){
                0->ListRoute()
                1->WeekRoute()
                2->HabitRoute()
                3->MineRoute()
            }
        }

        MyNavigationBar(
            destinations = TopLevelDestination.entries,
            currentDestination = currentDestination,
            onNavigationToDestination = {index ->
                currentDestination = TopLevelDestination.entries[index].route
                scope.launch {
                    pagerState.animateScrollToPage(index)
                }
            },
            modifier = Modifier
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun MainScreenPreview() {
    ListTheme {
        MainScreen()
    }
}