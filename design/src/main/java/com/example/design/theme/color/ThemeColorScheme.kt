package com.example.design.theme.color

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

sealed class ThemeColorScheme(
//    val isDark: Boolean,

    val maincolor: ColorMap,
    val gray: ColorMap = ColorMap(
        100 to Color(0xFFF5F5F5),
        200 to Color(0xFFECECEC),
        300 to Color(0xFFCACACA),
        400 to Color(0xFF838383),
        500 to Color(0xFF4B4B4B),
        600 to Color(0xFF2A2E37),
    ),

    val black: Color = Color(0xFF000000),
    val white: Color = Color(0xFFFFFFFF),
    val background: Color = Color(0xFFFCFAF4),
    val negative: Color = Color(0xFFF44336),
)