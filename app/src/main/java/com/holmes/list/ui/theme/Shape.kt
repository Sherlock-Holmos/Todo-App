package com.holmes.list.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

// region 默认圆角形状（适用于全局主题）
val ShapeExtraLarge = RoundedCornerShape(32.dp) // 用于对话框或大型组件
val ShapeLarge = RoundedCornerShape(24.dp) // 用于卡片和容器
val ShapeMedium = RoundedCornerShape(16.dp) // 用于按钮或中型组件
val ShapeSmall = RoundedCornerShape(8.dp) // 用于小型控件，如输入框
val ShapeExtraSmall = RoundedCornerShape(4.dp) // 用于微小元素或边框
// endregion

// region 自定义动态圆角形状（支持灵活调整）
@Composable
fun RoundedShape(allCorners: Float = 16f): Shape {
    return RoundedCornerShape(allCorners.dp)
}

@Composable
fun RoundedShape(
    topStart: Float = 16f,
    topEnd: Float = 16f,
    bottomEnd: Float = 16f,
    bottomStart: Float = 16f
): Shape {
    return RoundedCornerShape(
        topStart.dp,
        topEnd.dp,
        bottomEnd.dp,
        bottomStart.dp
    )
}
// endregion

// region 特定场景的形状设计（参考主流应用设计）
val TopRoundedShape = RoundedCornerShape(
    topStart = 16.dp,
    topEnd = 16.dp,
    bottomStart = 0.dp,
    bottomEnd = 0.dp
) // 用于顶部圆角的卡片或模态框

val BottomRoundedShape = RoundedCornerShape(
    topStart = 0.dp,
    topEnd = 0.dp,
    bottomStart = 16.dp,
    bottomEnd = 16.dp
) // 用于底部圆角的容器或底部弹出框

val LeftRoundedShape = RoundedCornerShape(
    topStart = 16.dp,
    topEnd = 0.dp,
    bottomStart = 16.dp,
    bottomEnd = 0.dp
) // 用于左侧圆角的元素

val RightRoundedShape = RoundedCornerShape(
    topStart = 0.dp,
    topEnd = 16.dp,
    bottomStart = 0.dp,
    bottomEnd = 16.dp
) // 用于右侧圆角的元素

val FullRoundedShape = RoundedCornerShape(50) // 用于完全圆形的组件（如头像或按钮）

val CutCornerShapeExample = CutCornerShape(
    topStart = 16.dp,
    topEnd = 0.dp,
    bottomEnd = 16.dp,
    bottomStart = 0.dp
) // 特殊切角效果，用于强调独特设计
// endregion

// region Material Design 3 推荐形状定义（适配 MD3 风格）
val MD3ExtraLarge = RoundedCornerShape(28.dp) // 大型卡片、对话框
val MD3Large = RoundedCornerShape(20.dp) // 中型卡片、容器
val MD3Medium = RoundedCornerShape(12.dp) // 按钮、输入框
val MD3Small = RoundedCornerShape(6.dp) // 图标按钮或微小元素
// endregion

// region 特殊用途动态形状
@Composable
fun DynamicCutCornerShape(allCorners: Float): Shape {
    return CutCornerShape(allCorners.dp)
}

@Composable
fun DynamicCutCornerShape(
    topStart: Float = 0f,
    topEnd: Float = 0f,
    bottomEnd: Float = 0f,
    bottomStart: Float = 0f
): Shape {
    return CutCornerShape(
        topStart.dp,
        topEnd.dp,
        bottomEnd.dp,
        bottomStart.dp
    )
}
// endregion
