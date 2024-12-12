package com.example.kursach_app.view.channel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.channel.ChannelResponse
import com.example.kursach_app.data.models.channel.Video
import com.example.kursach_app.ui.components.VideoCard
import com.example.kursach_app.utils.ApiResponse

@Composable
fun ChannelScreen(
    navController: NavController,
    channelId: String?,
    viewModel: ChannelViewModel = hiltViewModel()
) {
    val response by viewModel.channelResponse.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getChannelInfo(channelId!!)

    }
    var name by remember {
        mutableStateOf("")
    }

    var imageUrl by remember {
        mutableStateOf("")
    }
    var videos by remember {
        mutableStateOf<List<Video>>(emptyList())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AsyncImage(
                model = "http://10.0.2.2:8080/${imageUrl}",
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Gray),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = name,
                fontSize = 22.sp,
                color = Color.LightGray,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Button(
                onClick = { viewModel.subscribe(channelId!!) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1DB954), // Зеленый цвет в стиле Spotify
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(48.dp)
            ) {
                Text(text = "Подписаться", fontSize = 16.sp)
            }
        }


        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(videos.count()) { pos ->
                VideoCard(
                    navController = navController,
                    title = videos[pos].title,
                    channelId = channelId!!,
                    channelName = videos[pos].channelName,
                    imageUrl = videos[pos].previewUrl,
                    channelImageUrl = videos[pos].channelImageUrl,
                    videoId = videos[pos].id
                )
            }
        }
    }



    when (response) {
        is ApiResponse.Failure -> {
            println((response as ApiResponse.Failure).errorMessage)
        }

        ApiResponse.Loading -> {
            println("loading")
        }

        is ApiResponse.Success -> {
            val data = (response as ApiResponse.Success<ResponseBody<ChannelResponse>>).data.data
            name = data.userDTO.username
            imageUrl = data.userDTO.imageUrl
            videos = data.videos
        }
    }

}
