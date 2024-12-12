package com.example.kursach_app.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SearchScreen() {
    Scaffold(topBar = {
        Row(
            modifier = Modifier.padding(
                top = 8.dp,
            ), verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
            OutlinedTextField(
                leadingIcon = {
                    Box(
                        modifier = Modifier.padding(
                            start = 10.dp
                        )
                    ) {
                        Text(text = "Поиск")
                    }
                },
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                shape = RoundedCornerShape(40.dp),
                value = "",
                onValueChange = {

                })

        }
    }) { _ ->

    }
}


@Composable
@Preview
fun SearchScreenPreview() {
    SearchScreen()
}