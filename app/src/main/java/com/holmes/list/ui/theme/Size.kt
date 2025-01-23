package com.holmes.list.ui.theme

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


//region 分割尺寸
val Space4XLarge = 40.dp
val Space3XLarge = 30.dp
val SpaceOuter = 20.dp
val SpaceExtraOuterMedium = 15.dp
val SpaceMedium = 10.dp
val SpaceExtraSmall = 7.dp
val SpaceSmall = 5.dp
val SpaceExtraSmall2 = 2.dp
val SpaceExtraSmall3 = 0.9.dp
//endregion

@Composable
fun SpaceSmallHeight(): Unit {
    Spacer(modifier = Modifier.height(SpaceSmall))
}

@Composable
fun SpaceExtramSmall2Height(): Unit {
    Spacer(modifier = Modifier.height(SpaceExtraSmall2))
}

@Composable
fun SpaceExtramSmall3Height(): Unit {
    Spacer(modifier = Modifier.height(SpaceExtraSmall3))
}

