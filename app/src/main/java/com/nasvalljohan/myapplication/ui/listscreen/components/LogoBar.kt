package com.nasvalljohan.myapplication.ui.listscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nasvalljohan.myapplication.R

@Composable
fun LogoBar() {
    Row(Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Image(painter = painterResource(id = R.drawable.umain_logo), contentDescription = null, modifier = Modifier.size(54.dp))
        Spacer(Modifier.width(54.dp))
    }
}
