package com.example.kursach_app.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun InfoText(text: String, color: Color = Color.Black, fontSize:Int = 16) {
    Text(
        text = text,

        fontSize = fontSize.sp,
        color = color
    )
}

@Preview(showBackground = true)
@Composable
fun InfoTextPreview() {
    InfoText(text = "Lorem ipsum")
}