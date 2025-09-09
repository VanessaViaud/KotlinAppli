package com.example.kotlintp.ui.theme

import android.R.attr.padding
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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
fun InputButton(onClick: () -> Unit, textButton: String = "Invalid") {
    Button(
        contentPadding = PaddingValues(0.dp),
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
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
            ){
            Text(textButton)
        }
    }
}



