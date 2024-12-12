package com.example.kursach_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kursach_app.view.channel.ChannelScreen
import com.example.kursach_app.view.MyFavoritesScreen
import com.example.kursach_app.view.MyHistoryScreen
import com.example.kursach_app.view.profile.ProfileScreen
import com.example.kursach_app.view.homePage.HomePage
import com.example.kursach_app.view.subscribes.SubscribesScreen
import com.example.kursach_app.view.login.LoginScreen
import com.example.kursach_app.view.register.RegisterScreen
import com.example.kursach_app.view.watch.WatchScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String = Screens.LoginScreen.route
) {
    NavHost(navController, startDestination = startDestination) {
        composable(Screens.StartScreen.route) {
            HomePage(navController)
        }
        composable(Screens.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(Screens.RegisterScreen.route) {
            RegisterScreen(navController)
        }
        composable(Screens.MyHistoryScreen.route) {
            MyHistoryScreen()
        }
        composable(Screens.MyFavoritesScreen.route) {
            MyFavoritesScreen()
        }
        composable(Screens.SubscribesScreen.route) {
            SubscribesScreen(navController)
        }
        composable(Screens.ProfileScreen.route) {
            ProfileScreen()
        }
        composable(
            route = "channel_screen/{channelId}",
        ) { backStackEntry ->
            val channelId = backStackEntry.arguments?.getString("channelId")
            ChannelScreen(channelId = channelId, navController = navController)

        }

        composable(
            route = "watch_screen/{videoId}",
        ) { backStackEntry ->
            val videoId = backStackEntry.arguments?.getString("videoId")

            WatchScreen(videoId!!)
        }
    }
}