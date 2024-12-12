package com.example.kursach_app.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kursach_app.ui.components.VideoCardSmall

@Composable
fun MyHistoryScreen() {
    LazyColumn(modifier = Modifier.padding(bottom = 5.dp)) {
        items(10) {
            VideoCardSmall()
            Spacer(modifier = Modifier.padding(5.dp))
        }
    }
}
