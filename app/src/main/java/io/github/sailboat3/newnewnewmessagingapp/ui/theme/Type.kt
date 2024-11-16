package io.github.sailboat3.newnewnewmessagingapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.github.sailboat3.newnewnewmessagingapp.R

val speedeeFamily = FontFamily(
    Font(R.font.speedee_light, FontWeight.Light),
    Font(R.font.speedee_lightitalic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.speedee_regular, FontWeight.Normal),
    Font(R.font.speedee_regularitalic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.speedee_bold, FontWeight.Bold),
    Font(R.font.speedee_bolditalic, FontWeight.Light, FontStyle.Italic)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = speedeeFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

