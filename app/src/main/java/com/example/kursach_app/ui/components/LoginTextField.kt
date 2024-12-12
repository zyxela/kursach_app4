package com.example.medapp.ui.components.textfields

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kursach_app.ui.theme.BlueLight


@Composable
fun LoginTextField(
    hint: String,
    value: String,
    isPassword: Boolean = false,
    onValueChange: (String) -> Unit
) {

    TextField(
        modifier = Modifier
            .padding(0.dp, 0.dp, 0.dp, 10.dp)
            .shadow(10.dp),
        shape = RoundedCornerShape(15.dp),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text(
                text = hint,
                fontSize = 20.sp,
                fontWeight = FontWeight(550),

                color = BlueLight
            )
        },
        value = value,
        onValueChange = onValueChange

    )
}


@Composable
@Preview(showBackground = true)
fun LoginTextFieldPreview() {
    LoginTextField("Email", "") {

    }
}