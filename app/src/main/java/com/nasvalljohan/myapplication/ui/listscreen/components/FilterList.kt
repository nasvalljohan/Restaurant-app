package com.nasvalljohan.myapplication.ui.listscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nasvalljohan.myapplication.R
import com.nasvalljohan.myapplication.ui.theme.DarkText
import com.nasvalljohan.myapplication.ui.theme.LightText
import com.nasvalljohan.myapplication.ui.theme.Selected
import com.nasvalljohan.myapplication.ui.theme.font.TextTitle2
import com.nasvalljohan.myapplication.viewmodel.ListScreenEvent
import com.nasvalljohan.myapplication.viewmodel.ListScreenState

@Composable
fun FilterList(onEvent: (ListScreenEvent) -> Unit, state: ListScreenState) {
    LazyRow(
        modifier = Modifier
            .size(width = 480.dp, height = 48.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        itemsIndexed(state.filters) { index, filter ->
            if (index < 1) {
                Spacer(Modifier.width(21.dp))
            }
            FilterListItem(
                image = filter.image_url,
                contentDescription = filter.name,
                text = filter.name,
                onEvent = onEvent,
                filterId = filter.id,
                buttonId = index,
                selectedButtonId = state.selectedButtonId,
            )
            if (index == state.filters.size - 1) {
                Spacer(Modifier.width(21.dp))
            }
        }
    }
}

@Composable
private fun getButtonBackground(buttonId: Int, selectedButtonId: Int): Color {
    return if (buttonId == selectedButtonId) Selected else Color.White
}

@Composable fun getTextColor(buttonId: Int, selectedButtonId: Int): Color {
    return if (buttonId == selectedButtonId) LightText else DarkText
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FilterListItem(
    image: String,
    contentDescription: String,
    text: String,
    onEvent: (ListScreenEvent) -> Unit,
    filterId: String,
    buttonId: Int,
    selectedButtonId: Int,
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        onClick = {
            onEvent(ListScreenEvent.FilterEvent(filterId = filterId, selectedButtonId = buttonId))
        },
        modifier = Modifier
            .height(48.dp)
            .wrapContentSize()
            .clip(RoundedCornerShape(24.dp)),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(24.dp))
                .background(getButtonBackground(buttonId = buttonId, selectedButtonId = selectedButtonId)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Box(modifier = Modifier.size(48.dp)) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(image)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.placeholder),
                    contentDescription = contentDescription,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxSize(),
                )
            }
            TextTitle2(
                text = text,
                color = getTextColor(buttonId = buttonId, selectedButtonId = selectedButtonId),
                modifier = Modifier
                    .padding(end = 16.dp),
            )
        }
    }
}
