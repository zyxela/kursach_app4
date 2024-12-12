package com.example.kursach_app.view.register

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.kursach_app.data.models.ResponseBody
import com.example.kursach_app.data.models.auth.AuthResponse
import com.example.kursach_app.navigation.Screens
import com.example.kursach_app.ui.components.InfoText
import com.example.kursach_app.ui.components.LinkText
import com.example.kursach_app.ui.components.TitleText
import com.example.kursach_app.ui.theme.LoginGradient
import com.example.kursach_app.utils.ApiResponse
import com.example.medapp.ui.components.buttons.ActionButton
import com.example.medapp.ui.components.textfields.LoginTextField

@Composable
fun RegisterScreen(navController: NavController, viewModel: RegisterViewModel = hiltViewModel()) {
    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    val response by viewModel.token.collectAsState()
    var showToast by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(LoginGradient))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(35.dp, 260.dp, 35.dp, 50.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(horizontalAlignment = Alignment.Start) {
                        TitleText(text = "Регистрация")
                        LoginTextField("Имя", name) { name = it }
                        LoginTextField("Email", login) { login = it }
                        LoginTextField("Пароль", password, true) { password = it }
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        ActionButton(
                            120,
                            text = " Вперед "
                        ) {
                            viewModel.login(name, login, password)
                        }
                        Row {
                            InfoText(text = "Уже есть аккаунт? ", Color.White)
                            LinkText(text = "Войти") {
                                navController.navigate(Screens.LoginScreen.route)
                            }
                        }
                    }
                }
            }
        }
    }

    LaunchedEffect(response) {
        when (response) {
            is ApiResponse.Failure -> {
                if (showToast) {
                    showToast = false
                    Toast.makeText(
                        context,
                        (response as ApiResponse.Failure).errorMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            is ApiResponse.Success -> {
                val successResponse = response as ApiResponse.Success<ResponseBody<AuthResponse>>
                viewModel.setToken(successResponse.data.data.token)
                navController.navigate(Screens.StartScreen.route)
            }

            else -> Unit
        }
    }
}