package com.example.medapp.ui.components.buttons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ActionButton(width: Int, text: String, color: Color = Color.Blue, onClick: () -> Unit) {
    Box(modifier = Modifier.padding(3.dp)) {

        Card(
            shape = RoundedCornerShape(60.dp),
            modifier = Modifier
                .height(60.dp)
                .width(width.dp)
                .padding(0.dp, 10.dp, 0.dp, 12.dp)
                .blur(2.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0, 0, 0, 60)
            ),


            ) {

        }
        Button(
            modifier = Modifier
                .width(width.dp),
            colors = ButtonDefaults.buttonColors(color),
            shape = RoundedCornerShape(25),
            onClick = onClick
        ) {

            Text(text = text, color = Color.White, fontSize = 18.sp)


        }
    }
}

@Preview(showBackground = true)
@Composable
fun ActionButtonPreview() {
    ActionButton(100, "Enter") {}
}