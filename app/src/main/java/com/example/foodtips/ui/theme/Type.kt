package com.example.foodtips.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import com.example.foodtips.*
import com.example.foodtips.R

val Josefinsans = FontFamily(
        Font(R.font.josefinsans_semibold),
        Font(R.font.josefinsans_italic),
        Font(R.font.josefinsans_regular)
)

val Lora = FontFamily(
        Font(R.font.lora_bolditalic,FontWeight.SemiBold),
        Font(R.font.lora_semibolditalic,FontWeight.Bold),
)
val Poltawskinowy = FontFamily(
        Font(R.font.poltawskinowy_bold)
)
// Set of Material typography styles to start with
val Typography = Typography(
        bodyLarge = TextStyle(
                fontFamily = Josefinsans,
                fontWeight = FontWeight.Normal,
                fontSize = 50.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp,
                color = Color(0xFF2A062A)
        ),
        bodyMedium = TextStyle(
                fontFamily = Josefinsans,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.sp,
                color = Color(0xFF2A062A)
                
        ),
        titleLarge = TextStyle(
        fontFamily = Josefinsans,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
                color = Color(0xFF2A062A)
    ),
        headlineMedium = TextStyle(
                fontFamily = Lora,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                letterSpacing = 0.5.sp,
                lineHeight = 20.sp,
                color = Color(0xFF2A062A)
        ),
        bodySmall = TextStyle(
                fontFamily = Lora,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.5.sp,
                color = Color(0xFF2A062A)
        ),
    titleMedium = TextStyle(
            fontFamily = Poltawskinowy,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.5.sp,
            color = Color(0xFF000000)
    ),
)