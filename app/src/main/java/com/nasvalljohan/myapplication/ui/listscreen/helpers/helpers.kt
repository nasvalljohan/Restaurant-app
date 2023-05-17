package com.nasvalljohan.myapplication.ui.listscreen.helpers // ktlint-disable filename

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.nasvalljohan.myapplication.Constants
import com.nasvalljohan.myapplication.ui.theme.DarkText
import com.nasvalljohan.myapplication.ui.theme.LightText
import com.nasvalljohan.myapplication.ui.theme.Selected

@Composable
fun translateIdToCategory(id: String): String {
    return Constants.filterToCategoryMap[id] ?: "Unknown"
}

@Composable
fun getBackgroundColor(buttonId: Int, selectedButtonId: Int): Color {
    return if (buttonId == selectedButtonId) Selected else Color.White
}

@Composable
fun getTextColor(
    buttonId: Int = 1,
    selectedButtonId: Int = 1,
    boolean: Boolean = false,
    color1: Color = LightText,
    color2: Color = DarkText,
): Color {
    return if (buttonId == selectedButtonId || boolean) color1 else color2
}
