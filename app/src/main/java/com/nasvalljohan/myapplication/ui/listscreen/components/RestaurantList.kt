package com.nasvalljohan.myapplication.ui.listscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import com.nasvalljohan.myapplication.ui.listscreen.helpers.translateIdToCategory
import com.nasvalljohan.myapplication.ui.repository.model.Restaurant
import com.nasvalljohan.myapplication.ui.theme.DarkText
import com.nasvalljohan.myapplication.ui.theme.Footer
import com.nasvalljohan.myapplication.ui.theme.Subtitle
import com.nasvalljohan.myapplication.ui.theme.font.TextFooter1
import com.nasvalljohan.myapplication.ui.theme.font.TextSubtitle1
import com.nasvalljohan.myapplication.ui.theme.font.TextTitle1
import com.nasvalljohan.myapplication.viewmodel.ListScreenEvent
import com.nasvalljohan.myapplication.viewmodel.ListScreenState

@Composable
fun RestaurantList(onEvent: (ListScreenEvent) -> Unit, state: ListScreenState) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(state.restaurantList) { item ->
            ListItem(onEvent = onEvent, restaurant = item)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ListItem(
    onEvent: (ListScreenEvent) -> Unit,
    restaurant: Restaurant,
) {
    ElevatedCard(
        modifier = Modifier
            .size(343.dp, 196.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topEnd = 12.dp, topStart = 12.dp))
                .clickable { onEvent(ListScreenEvent.RestaurantSelectedEvent(restaurant.id)) },
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(restaurant.image_url)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.placeholder),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .align(Alignment.BottomStart),
            ) {
                Column(
                    modifier = Modifier.padding(8.dp).fillMaxWidth(),
                    verticalArrangement = Arrangement.Top.also { Arrangement.spacedBy(2.dp) },
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        TextTitle1(text = restaurant.name, color = DarkText)
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(3.dp),
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.star_icon),
                                contentDescription = null,
                                modifier = Modifier.size(12.dp),
                                tint = Color.Yellow,
                            )
                            TextFooter1(text = restaurant.rating.toString(), color = DarkText)
                        }
                    }
                    if (restaurant.filterIds.isNotEmpty()) {
                        LazyRow {
                            restaurant.let {
                                itemsIndexed(it.filterIds) { index, id ->
                                    TextSubtitle1(
                                        text = translateIdToCategory(id),
                                        color = Subtitle,
                                    )
                                    if (index < it.filterIds.size - 1) {
                                        TextSubtitle1(text = " • ", color = Subtitle)
                                    }
                                }
                            }
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(3.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.clock_icon),
                            contentDescription = "Down",
                            modifier = Modifier.size(10.dp),
                            tint = Color.Red,
                        )
                        TextFooter1(
                            text = "${restaurant.delivery_time_minutes} min",
                            color = Footer,
                        )
                    }
                }
            }
        }
    }
}
