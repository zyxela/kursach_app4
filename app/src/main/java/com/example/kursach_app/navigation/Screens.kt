package com.example.kursach_app.navigation

sealed class Screens(val route:String) {
    data object StartScreen:Screens("start_screen")
    data object LoginScreen:Screens("login_screen")
    data object RegisterScreen:Screens("register_screen")
    data object SubscribesScreen:Screens("subscribes_screen")
    data object MyFavoritesScreen:Screens("my_favorites_screen")
    data object MyHistoryScreen:Screens("my_history_screen")
    data object ProfileScreen:Screens("profile_screen")
    data object ChannelScreen:Screens("channel_screen/{channelId}")
    data object WatchScreen:Screens("watch_screen")
}