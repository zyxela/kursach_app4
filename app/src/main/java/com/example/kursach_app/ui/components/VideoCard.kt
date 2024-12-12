package com.example.kursach_app.ui.components

import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.PaintDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.kursach_app.R
import com.example.kursach_app.data.models.channel.Video
import com.example.kursach_app.navigation.Screens

@Composable
fun VideoCard(
    navController: NavController,
    videoId: String,
    title: String,
    channelId:String,
    channelName: String,
    imageUrl: String,
    channelImageUrl: String
) {
    Card(shape = RoundedCornerShape(0.dp)) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clickable {
                        navController.navigate("watch_screen/$videoId")
                    },
                model = "http://10.0.2.2:8080/${imageUrl}",
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Row(modifier = Modifier.padding(5.dp)) {
                Card(
                    modifier = Modifier
                        .size(50.dp),
                    shape = RoundedCornerShape(100.dp),
                    onClick = {
                        navController.navigate("channel_screen/$channelId")
                    }) {
                    AsyncImage(
                        model = "http://10.0.2.2:8080/${channelImageUrl}",
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
                Column(modifier = Modifier.padding(5.dp, 5.dp)) {
                    Text(text = title)
                    Text(text = channelName, color = Color.Gray)
                }
            }

        }
    }
}


@Preview
@Composable
fun VideoCardPreview() {
    Surface {
        Column {

        }

    }

}