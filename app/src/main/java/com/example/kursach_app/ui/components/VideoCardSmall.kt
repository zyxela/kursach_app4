package com.example.kursach_app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VideoCardSmall() {
    Row() {
        Image(
            modifier = Modifier
                .height(100.dp)
                .width(160.dp),
            painter = ColorPainter(Color.DarkGray),
            contentDescription = null
        )
        Column(modifier = Modifier.padding(start = 4.dp)) {
            Text(text = "VideoNameVideoName", fontSize = 14.sp, fontWeight = FontWeight(500))
            Text(text = "Channel", color = Color.Gray)
        }
    }
}


@Composable
@Preview
fun VideoCardSmallPreview() {
    Box(modifier = Modifier.background(Color.White)) {
        VideoCardSmall()
    }
}