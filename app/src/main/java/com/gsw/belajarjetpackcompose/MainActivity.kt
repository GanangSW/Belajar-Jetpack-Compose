package com.gsw.belajarjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gsw.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BelajarJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
//        simple button
        Button(onClick = { }) {
            Text(text = "Simple Button")
        }

        Spacer(modifier = Modifier.height(5.dp))
//        simple button custom background color
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Yellow,
                contentColor = Color.White
            )
        ) {
            Text(text = "Simple Button")
        }

        Spacer(modifier = Modifier.height(5.dp))
//        text Button
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Text Button")
        }

        Spacer(modifier = Modifier.height(5.dp))
//        rounded button
        Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(15.dp)) {
            Text(text = "Rounded Button")
        }

        Spacer(modifier = Modifier.height(5.dp))
//        outline button
        OutlinedButton(
            onClick = { /*TODO*/ },
            border = BorderStroke(width = 2.dp, color = Color.Yellow)
        ) {
            Text(text = "Outline Button")
        }
        Spacer(modifier = Modifier.height(5.dp))
//        outline button with icon
        OutlinedButton(
            onClick = { /*TODO*/ },
            border = BorderStroke(width = 2.dp, color = Color.Yellow)
        ) {
            Icon(Icons.Default.Favorite, contentDescription = "Button")
            Text(text = "Outline Icon Button")
        }
    }
}





