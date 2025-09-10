package com.example.kotlintp.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlintp.R

@Composable
fun TemplatePage(content: @Composable () -> Unit) {
    KotlinTpTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            //Box : composant qui permet de gérer du calque
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .background(brush = verticalGradientBrush)
            ) {
                content()
            }

        }
    }
}

@Composable
fun IconDesign(id: Int = R.drawable.user_icon, size: Int) {
    Icon(
        painter = painterResource(id),
        contentDescription = "",
        modifier = Modifier.size(size.dp),
        tint = Color.White,
    )
}

@Composable
fun TextDesign(textContent: String) {
    Text(
        text = textContent,
        color = textColor,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        fontSize = 24.sp,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    )
}

@Composable
fun WrapPadding(content: @Composable () -> Unit) {
    Box(modifier = Modifier.padding(5.dp)) { content() }
}

@Composable
fun CardContainer(content: @Composable () -> Unit) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardColor,
        )
    ) { content() }
}

@Composable
fun TextFieldDesign(textContent: String) {
    var textFieldContent by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier
            .fillMaxWidth(),

        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        ),
        onValueChange = { textFieldContent = it },
        value = textFieldContent,
        placeholder = {
            Text(
                textContent,
                color = textColorButton,
            )
        })
}

@Composable
fun InputButton(onClick: () -> Unit, textButton: String = "Invalid") {
    Button(
        contentPadding = PaddingValues(0.dp),
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .padding(vertical = 30.dp)
            .background(brush = horizontalGradientBrush, shape = ButtonDefaults.shape)
            .border(BorderStroke(2.dp, Color.White), shape = ButtonDefaults.shape),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(brush = horizontalGradientBrush)
                .padding(vertical = 14.dp),
        ) {
            Text(textButton)
        }
    }
}



