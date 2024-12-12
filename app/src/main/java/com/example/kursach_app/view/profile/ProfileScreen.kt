package com.example.kursach_app.view.profile

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.profile.ProfileResponse
import com.example.kursach_app.ui.components.VideoCard
import com.example.kursach_app.utils.ApiResponse

@Composable
fun ProfileScreen(viewModel: ProfileViewModel = hiltViewModel()) {
    val response by viewModel.profileInfo.collectAsState()

    var name by remember { mutableStateOf("") }
    var imageUrl by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        viewModel.getProfile()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212)) // Тёмный фон
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                shape = RoundedCornerShape(40.dp),
                modifier = Modifier
                    .size(60.dp)
            ) {
                AsyncImage(
                    modifier = Modifier.size(70.dp),
                    model = "http://10.0.2.2:8080/$imageUrl",
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = name,
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Подписчики: 10.5K",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }

        Divider(color = Color.Gray, thickness = 0.5.dp, modifier = Modifier.padding(vertical = 8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { /* Мои видео */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp)
            ) {
                Text(text = "Мои видео")
            }
            Button(
                onClick = { /* Загрузить видео */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp)
            ) {
                Text(text = "Загрузить видео")
            }
        }


        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(10) { index ->
              /*  VideoCard(
                    title = "Видео $index",
                    channelName = name,
                    imageUrl = "https://via.placeholder.com/150",
                    channelImageUrl = "https://via.placeholder.com/50"
                )*/
                Spacer(modifier = Modifier.height(6.dp))
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
            val data = (response as ApiResponse.Success<ResponseBody<ProfileResponse>>).data.data
            name = data.username
            imageUrl = data.imageUrl
        }
    }
}

