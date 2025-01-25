package com.holmes.list.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.holmes.list.extension.clickableNoRipple
import com.holmes.list.feature.main.TopLevelDestination
import com.holmes.list.ui.theme.SpaceExtraSmall3Height

/**
 * 底部导航
 */
@Composable
fun MyNavigationBar(
    destinations: List<TopLevelDestination>,
    currentDestination: String,
    onNavigationToDestination: (Int) -> Unit,
    modifier: Modifier = Modifier,
): Unit {
    HorizontalDivider()
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(5.dp)

    ) {
        destinations.forEachIndexed { index, destination ->
            val selected = destination.route == currentDestination
            val color = if (selected) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.onSurface

            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .clickableNoRipple() {
                        onNavigationToDestination(index)
                    }) {
                Image(
                    painter = painterResource(
                        id = if (selected) destination.selectedIcon
                        else destination.unselectedIcon
                    ), contentDescription = null, modifier = Modifier.size(25.dp)
                )

                SpaceExtraSmall3Height()

                Text(
                    text = stringResource(id = destination.titleTextId),
                    color = color,
                    style = MaterialTheme.typography.labelSmall
                )
            }

        }
    }
}