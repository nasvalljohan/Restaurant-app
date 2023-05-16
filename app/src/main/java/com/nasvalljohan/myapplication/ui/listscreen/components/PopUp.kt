package com.nasvalljohan.myapplication.ui.listscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nasvalljohan.myapplication.R
import com.nasvalljohan.myapplication.ui.theme.Background
import com.nasvalljohan.myapplication.ui.theme.DarkText
import com.nasvalljohan.myapplication.ui.theme.Positive
import com.nasvalljohan.myapplication.ui.theme.Subtitle
import com.nasvalljohan.myapplication.ui.theme.font.TextHeadline1
import com.nasvalljohan.myapplication.ui.theme.font.TextHeadline2
import com.nasvalljohan.myapplication.ui.theme.font.TextTitle1
import com.nasvalljohan.myapplication.viewmodel.ListScreenEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopUp(onEvent: (ListScreenEvent) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().background(Background),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(220.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Green),
            )
            Icon(
                painter = painterResource(id = R.drawable.chevron),
                contentDescription = "Close pop-up",
                modifier = Modifier
                    .padding(top = 40.dp, start = 22.dp)
                    .align(Alignment.TopStart)
                    .clickable { onEvent(ListScreenEvent.BackPress) },
            )
        }

        ElevatedCard(
            modifier = Modifier
                .offset(y = (-45).dp)
                .size(343.dp, 144.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                TextHeadline1(text = "Emilias Fancy Food", color = DarkText)
                TextHeadline2(text = "Take-Out - Fast Delivery - Eat-In", color = Subtitle)
                TextTitle1(text = "Open", color = Positive)
            }
        }
    }
}
