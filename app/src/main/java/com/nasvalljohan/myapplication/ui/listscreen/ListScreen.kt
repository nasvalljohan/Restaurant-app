package com.nasvalljohan.myapplication.ui.listscreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
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
import com.nasvalljohan.myapplication.ui.listscreen.components.PopUp
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
            isPopUpOpen = viewModel.isPopUpOpen.value,
        )
    }
}

@Composable
fun ListScreenContent(
    onEvent: (ListScreenEvent) -> Unit,
    isPopUpOpen: Boolean,
) {
    Box(modifier = Modifier.fillMaxSize()) {
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
        AnimatedVisibility(
            visible = isPopUpOpen,
            enter = slideInVertically(
                initialOffsetY = { it },
                animationSpec = tween(
                    durationMillis = 350,
                    easing = LinearOutSlowInEasing,
                ),
            ),
            exit = slideOutVertically(
                targetOffsetY = { it },
                animationSpec = tween(
                    durationMillis = 350,
                    easing = LinearOutSlowInEasing,
                ),
            ),
        ) {
            PopUp()
        }
    }
}
