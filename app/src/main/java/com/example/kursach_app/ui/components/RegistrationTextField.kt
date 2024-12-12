package com.example.medapp.ui.components.textfields

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun RegistrationTextField(
    modifier: Modifier = Modifier,
    hint: String,
    value: String,
    isPassword: Boolean = false,
    onValueChange: (String) -> Unit
) {
    Box(modifier = modifier) {
        Card(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .blur(2.dp),
            shape = RoundedCornerShape(30),
            colors = CardDefaults.cardColors(
                containerColor = Color(132, 204, 22, 255),
                contentColor = Color.White
            )
        ) {

        }

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 0.dp),
            shape = RoundedCornerShape(15.dp),
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.Blue,
                disabledIndicatorColor = Color.White
            ),
            placeholder = {
                Text(
                    text = hint,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(550),

                    color = Color(132, 204, 22, 255)
                )
            },
            value = value,
            onValueChange = onValueChange

        )
    }

}

@Composable
@Preview(showBackground = true)
fun RegistrationTextFieldPreview() {

    RegistrationTextField(Modifier.padding(10.dp), "Email", "", false) {

    }

}