package com.gsw.belajarjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    val inputText = remember {
        mutableStateOf("")
    }
//    TextField(value = inputText.value, onValueChange = {
//        inputText.value = it
//    })

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
//        hint textfield
        /*TextField(
            value = inputText.value,
            onValueChange = {
                inputText.value = it
            },
            placeholder = {
                Text(text = "Masukkan text..")
            }
        )
        Spacer(modifier = Modifier.height(5.dp))*/
//        label textfield
        /*TextField(
            value = inputText.value,
            onValueChange = {
                inputText.value = it
            },
            label = {
                Text(text = "Masukkan text..")
            }
        )*/

//        outline textfield
        OutlinedTextField(
            value = inputText.value,
            onValueChange = {
                inputText.value = it
            },
            label = {
                Text(text = "Masukkan text..")
            }
        )
    }
}