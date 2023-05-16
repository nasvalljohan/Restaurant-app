package com.nasvalljohan.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.nasvalljohan.myapplication.ui.listscreen.ListScreen

@Composable
fun Root() {
    Content()
}

@Composable
private fun Content() {
    Column {
        ListScreen()
    }
}

@Preview
@Composable
fun Preview() {
    Content()
}
