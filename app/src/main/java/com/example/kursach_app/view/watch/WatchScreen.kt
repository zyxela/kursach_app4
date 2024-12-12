package com.example.kursach_app.view.watch


import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import androidx.annotation.OptIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultDataSourceFactory
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.PlayerView
import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.videos.VideoInfoResponse
import com.example.kursach_app.utils.ApiResponse


@Composable
fun WatchScreen(
    videoId: String,
    viewModel: WatchViewModel = hiltViewModel()
) {
    var commentText by remember { mutableStateOf("") }
    val context = LocalContext.current

    val info by viewModel.info.collectAsState()

    var videoUrl by remember {
        mutableStateOf("")
    }
    var videoTitle by remember {
        mutableStateOf("")
    }

    LaunchedEffect(Unit) {
        viewModel.getVideoInfo(videoId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            if (videoUrl!="")
                VideoPlayer(context = context, videoUrl = videoUrl)
        }

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = videoTitle,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))


        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { /*onLikeClick()*/ }) {
                    Icon(
                        imageVector = Icons.Default.ThumbUp,
                        contentDescription = "Like",
                        tint = Color.Green
                    )
                }
                Text(text = "12", color = Color.White)
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { /*onDislikeClick()*/ }) {
                    Icon(
                        imageVector = Icons.Default.ThumbUp,
                        contentDescription = "Dislike",
                        tint = Color.Red
                    )
                }
                Text(text = "312", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Comments",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(7) { comment ->
                Text(
                    text = "sdsdf",
                    color = Color.LightGray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = commentText,
                onValueChange = { commentText = it },
                placeholder = { Text(text = "Add a comment", color = Color.Gray) },
                modifier = Modifier.weight(1f)
            )

            IconButton(onClick = {
                if (commentText.isNotBlank()) {
                    //onAddComment(commentText)
                    commentText = ""
                }
            }) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Send Comment",
                    tint = Color.Blue
                )
            }
        }
    }

    when(info){
        is ApiResponse.Failure ->{
            println("errror")
        }
        ApiResponse.Loading ->{
            println("loading")
        }
        is ApiResponse.Success -> {
            val v = (info as ApiResponse.Success<ResponseBody<VideoInfoResponse>>).data.data
            videoTitle = v.title
            videoUrl = "http://10.0.2.2:8080/"+v.videoUrl
        }
    }

}

@OptIn(UnstableApi::class)
@SuppressLint("OpaqueUnitKey")
@Composable
fun VideoPlayer(context: Context, videoUrl: String) {
    val exoPlayer = remember {
        val customHttpDataSourceFactory = DefaultHttpDataSource.Factory()
            .setDefaultRequestProperties(mapOf("Range" to "bytes=0-"))

        val dataSourceFactory = DefaultDataSourceFactory(context, customHttpDataSourceFactory)

        val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(MediaItem.fromUri(Uri.parse(videoUrl)))

        ExoPlayer.Builder(context).build().apply {
            setMediaSource(mediaSource)
            prepare()
            playWhenReady = true
        }
    }

    DisposableEffect(
        AndroidView(
            factory = {
                PlayerView(context).apply {
                    player = exoPlayer
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    ) {
        onDispose {
            exoPlayer.release()
        }
    }
}


