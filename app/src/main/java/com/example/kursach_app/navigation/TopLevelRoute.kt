package com.example.kursach_app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.webkit.Profile

data class TopLevelRoute<T : Any>(val name: String, val route: T, val icon: ImageVector)


val topLevelRoutes = listOf(
    TopLevelRoute("Главная", Screens.StartScreen.route, Icons.Default.Home),
    TopLevelRoute("Подписки", Screens.SubscribesScreen.route, Icons.Default.List),
    TopLevelRoute("Любимое", Screens.MyFavoritesScreen.route, Icons.Default.Favorite),
    TopLevelRoute("История", Screens.MyHistoryScreen.route, Icons.Default.Refresh),
    TopLevelRoute("Профиль", Screens.ProfileScreen.route, Icons.Default.AccountCircle),
)
