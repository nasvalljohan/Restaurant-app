package com.nasvalljohan.myapplication.ui.listscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nasvalljohan.myapplication.R
import com.nasvalljohan.myapplication.ui.theme.DarkText
import com.nasvalljohan.myapplication.ui.theme.font.TextTitle2
import com.nasvalljohan.myapplication.viewmodel.ListScreenEvent

@Composable
fun FilterList(onEvent: (ListScreenEvent) -> Unit) {
    Row(
        modifier = Modifier
            .size(width = 480.dp, height = 48.dp)
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 21.dp),
    ) {
        FilterListItem(
            drawable = R.drawable.filter_top_rated,
            contentDescription = "Filter top rated restaurants",
            text = "Top Rated",
            modifier = Modifier
                .size(144.dp, 48.dp)
                .clickable { onEvent(ListScreenEvent.FilterEvent(0)) },
        )
        Spacer(Modifier.width(16.dp))
        FilterListItem(
            drawable = R.drawable.filter_take_out,
            contentDescription = "Filter take out restaurants",
            text = "Take-Out",
            modifier = Modifier
                .size(140.dp, 48.dp)
                .clickable { onEvent(ListScreenEvent.FilterEvent(1)) },
        )
        Spacer(Modifier.width(16.dp))
        FilterListItem(
            drawable = R.drawable.filter_fast_delivery,
            contentDescription = "Filter restaurants with fast delivery",
            text = "Fast Delivery",
            modifier = Modifier
                .size(162.dp, 48.dp)
                .clickable { onEvent(ListScreenEvent.FilterEvent(2)) },
        )
    }
}

@Composable
private fun FilterListItem(
    drawable: Int,
    contentDescription: String,
    text: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier
            .then(modifier)
            .clip(RoundedCornerShape(24.dp))
            .background(Color.White),
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = contentDescription,
            modifier = Modifier
                .size(48.dp)
                .align(Alignment.CenterStart),
        )
        TextTitle2(
            text = text,
            color = DarkText,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp),
        )
    }
}
