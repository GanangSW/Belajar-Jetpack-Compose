package com.gsw.belajarjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.gsw.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BelajarJetpackComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    var isChecked by remember {
        mutableStateOf(false)
    }
    var context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Switch") },
            )
        },
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {

                Switch(checked = isChecked,
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Red,
                        checkedTrackColor = Color.LightGray,
                        uncheckedThumbColor = Color.Green,
                        uncheckedTrackColor = Color.LightGray
                    ),
                    onCheckedChange = {
                        isChecked = !isChecked
                        if (isChecked) {
                            Toast.makeText(context, "Checked", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, "Unchecked", Toast.LENGTH_SHORT).show()
                        }
                    })
            }
        }
    )
}

