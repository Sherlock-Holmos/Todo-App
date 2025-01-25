package com.holmes.list.ui.theme

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// region 间隔尺寸定义
val Space5XLarge = 50.dp
val Space4XLarge = 40.dp
val Space3XLarge = 30.dp
val Space2XLarge = 25.dp
val SpaceXLarge = 20.dp
val SpaceLarge = 16.dp
val SpaceMedium = 12.dp
val SpaceSmall = 8.dp
val SpaceExtraSmall = 4.dp
val SpaceExtraSmall2 = 2.dp
val SpaceExtraSmall3 = 1.dp
// endregion

// region 垂直间隔
@Composable
fun SpacerVertical(space: Float = SpaceMedium.value) {
    Spacer(modifier = Modifier.height(space.dp))
}

@Composable
fun Space5XLargeHeight() {
    Spacer(modifier = Modifier.height(Space5XLarge))
}

@Composable
fun Space4XLargeHeight() {
    Spacer(modifier = Modifier.height(Space4XLarge))
}

@Composable
fun Space3XLargeHeight() {
    Spacer(modifier = Modifier.height(Space3XLarge))
}

@Composable
fun Space2XLargeHeight() {
    Spacer(modifier = Modifier.height(Space2XLarge))
}

@Composable
fun SpaceXLargeHeight() {
    Spacer(modifier = Modifier.height(SpaceXLarge))
}

@Composable
fun SpaceLargeHeight() {
    Spacer(modifier = Modifier.height(SpaceLarge))
}

@Composable
fun SpaceMediumHeight() {
    Spacer(modifier = Modifier.height(SpaceMedium))
}

@Composable
fun SpaceSmallHeight() {
    Spacer(modifier = Modifier.height(SpaceSmall))
}

@Composable
fun SpaceExtraSmallHeight() {
    Spacer(modifier = Modifier.height(SpaceExtraSmall))
}

@Composable
fun SpaceExtraSmall2Height() {
    Spacer(modifier = Modifier.height(SpaceExtraSmall2))
}

@Composable
fun SpaceExtraSmall3Height() {
    Spacer(modifier = Modifier.height(SpaceExtraSmall3))
}
// endregion

// region 水平间隔
@Composable
fun SpacerHorizontal(space: Float = SpaceMedium.value) {
    Spacer(modifier = Modifier.width(space.dp))
}

@Composable
fun Space5XLargeWidth() {
    Spacer(modifier = Modifier.width(Space5XLarge))
}

@Composable
fun Space4XLargeWidth() {
    Spacer(modifier = Modifier.width(Space4XLarge))
}

@Composable
fun Space3XLargeWidth() {
    Spacer(modifier = Modifier.width(Space3XLarge))
}

@Composable
fun Space2XLargeWidth() {
    Spacer(modifier = Modifier.width(Space2XLarge))
}

@Composable
fun SpaceXLargeWidth() {
    Spacer(modifier = Modifier.width(SpaceXLarge))
}

@Composable
fun SpaceLargeWidth() {
    Spacer(modifier = Modifier.width(SpaceLarge))
}

@Composable
fun SpaceMediumWidth() {
    Spacer(modifier = Modifier.width(SpaceMedium))
}

@Composable
fun SpaceSmallWidth() {
    Spacer(modifier = Modifier.width(SpaceSmall))
}

@Composable
fun SpaceExtraSmallWidth() {
    Spacer(modifier = Modifier.width(SpaceExtraSmall))
}

@Composable
fun SpaceExtraSmall2Width() {
    Spacer(modifier = Modifier.width(SpaceExtraSmall2))
}

@Composable
fun SpaceExtraSmall3Width() {
    Spacer(modifier = Modifier.width(SpaceExtraSmall3))
}
// endregion
