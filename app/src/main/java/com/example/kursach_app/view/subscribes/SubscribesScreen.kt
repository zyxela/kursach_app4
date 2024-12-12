package com.example.kursach_app.view.subscribes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.profile.SubscribesResponse
import com.example.kursach_app.ui.components.ChannelCardCircle
import com.example.kursach_app.utils.ApiResponse

@Composable
fun SubscribesScreen(
    navController: NavController,
    viewModel: SubscribesViewModel = hiltViewModel()
) {

    val subscribes by viewModel.subscribes.collectAsState()

    var subscribesList by remember {
        mutableStateOf<List<SubscribesResponse>>(emptyList())
    }

    LaunchedEffect(Unit) {
        viewModel.getMySubscribes()
    }


    Column(modifier = Modifier.padding(top = 5.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            LazyColumn(modifier = Modifier.width(340.dp)) {
                items(subscribesList.count()) {
                    val s = subscribesList[it]
                    Column(modifier = Modifier.padding(end = 5.dp)) {
                        ChannelCardCircle(navController, s.id, s.name, s.imageUrl)
                    }
                    Spacer(modifier = Modifier.size(10.dp))
                }
            }
        }
    }

    when (subscribes) {
        is ApiResponse.Failure -> {

        }

        ApiResponse.Loading -> {

        }

        is ApiResponse.Success -> {
            val res =
                (subscribes as ApiResponse.Success<ResponseBody<List<SubscribesResponse>>>).data.data
            subscribesList = res
        }
    }
}


