package com.example.kursach_app.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.FontScaling
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.kursach_app.navigation.Screens
import com.example.kursach_app.ui.AppFonts.titleFont
import com.example.kursach_app.ui.theme.Purple40


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar() {

    TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
        titleContentColor = MaterialTheme.colorScheme.primary,
    ), title = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 0.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                style = TextStyle(
                    brush = Brush.linearGradient(
                        colors = listOf(Cyan, Blue, Purple40 /*...*/)
                    )
                ), fontFamily = titleFont, fontSize = 34.sp,
                text = buildAnnotatedString {
                    append("W")
                    withStyle(SpanStyle(fontSize = 27.sp)) {
                        append("o")
                    }
                    append("W")
                    withStyle(SpanStyle(fontSize = 27.sp)) {
                        append("!!!")
                    }
                }
            )
            Row {
                IconButton(onClick = {

                }) {
                    Icon(
                        imageVector = Icons.Default.Notifications, contentDescription = null
                    )
                }

                IconButton(onClick = {

                }) {
                    Icon(
                        imageVector = Icons.Default.Search, contentDescription = null
                    )
                }
            }
        }


    })
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun NavTOpPreview() {
    Scaffold(topBar = { AppTopBar() }) { _ ->

    }
}