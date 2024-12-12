package com.example.kursach_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kursach_app.navigation.NavGraph
import com.example.kursach_app.navigation.Screens
import com.example.kursach_app.ui.components.AppTopBar
import com.example.kursach_app.ui.components.NavBottomBar
import com.example.kursach_app.ui.theme.Kursach_appTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kursach_appTheme {

                val navController = rememberNavController()
                val currentRoute =
                    navController.currentBackStackEntryAsState().value?.destination?.route

                Scaffold(

                    topBar = {
                        if (currentRoute != Screens.LoginScreen.route && currentRoute != Screens.RegisterScreen.route) {
                            AppTopBar()
                        }

                    },
                    bottomBar = {
                        if (currentRoute != Screens.LoginScreen.route && currentRoute != Screens.RegisterScreen.route) {
                            NavBottomBar(navController)
                        }
                    },

                    ) { innerPadding ->

                    Box(
                        modifier = Modifier.padding(
                            top = innerPadding.calculateTopPadding(),
                            bottom = innerPadding.calculateBottomPadding()
                        )
                    ) {
                        NavGraph(navController = navController)
                    }

                }


            }
        }
    }
}
