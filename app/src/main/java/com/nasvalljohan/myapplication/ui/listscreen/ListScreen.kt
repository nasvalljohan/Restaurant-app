package com.nasvalljohan.myapplication.ui.listscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nasvalljohan.myapplication.ui.listscreen.components.FilterList
import com.nasvalljohan.myapplication.ui.listscreen.components.LogoBar
import com.nasvalljohan.myapplication.ui.listscreen.components.RestaurantList
import com.nasvalljohan.myapplication.ui.theme.Background
import com.nasvalljohan.myapplication.viewmodel.ListScreenEvent
import com.nasvalljohan.myapplication.viewmodel.ListScreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListScreen(viewModel: ListScreenViewModel = koinViewModel()) {
    Box(
        modifier = Modifier
            .background(Background)
            .fillMaxSize(),
    ) {
        ListScreenContent(
            onEvent = {
                viewModel.handleEvents(it)
            },
        )
    }
}

@Composable
fun ListScreenContent(
    onEvent: (ListScreenEvent) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(22.dp),
    ) {
        LogoBar()
        FilterList(onEvent = onEvent)
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp),
        ) {
            RestaurantList(onEvent = onEvent)
        }
    }
}
