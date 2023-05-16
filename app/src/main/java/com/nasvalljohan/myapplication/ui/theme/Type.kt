package com.nasvalljohan.myapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nasvalljohan.myapplication.R

val Inter = FontFamily(
    Font(R.font.inter_var),
)

val Helvetica = FontFamily(
    Font(R.font.helvetica_medium, FontWeight.Medium),
    Font(R.font.helvetica_bold, FontWeight.Bold),
)

val Poppins = FontFamily(
    Font(R.font.poppins_medium),
)

val Typography = Typography(
    headlineLarge = TextStyle( // Headline1
        fontFamily = Helvetica,
        fontSize = 24.sp,
        fontWeight = FontWeight(400),
        lineHeight = 16.sp,
    ),
    headlineSmall = TextStyle( // Headline2
        fontFamily = Helvetica,
        fontSize = 16.sp,
        fontWeight = FontWeight(400),
        lineHeight = 16.sp,
    ),
    titleLarge = TextStyle( // Title1
        fontFamily = Helvetica,
        fontSize = 18.sp,
        fontWeight = FontWeight(400),
        lineHeight = 16.sp,
    ),
    titleMedium = TextStyle( // Title2
        fontFamily = Poppins,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 20.sp,
    ),
    titleSmall = TextStyle( // Subtitle1
        fontFamily = Helvetica,
        fontSize = 12.sp,
        fontWeight = FontWeight(700),
        lineHeight = 16.sp,
    ),
    bodySmall = TextStyle( // Footer
        fontFamily = Inter,
        fontSize = 10.sp,
        fontWeight = FontWeight.ExtraLight,
        lineHeight = 12.1.sp,
    ),
)
