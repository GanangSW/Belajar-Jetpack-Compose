package com.gsw.belajarjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
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
    val scaffoldState = rememberScaffoldState()
    var dialogShow by remember {
        mutableStateOf(false)
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "Alert Dialog") },
            )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = { dialogShow = true }) {
                    Text(text = "Show Dialog")
                }
                if (dialogShow) dialogShow = showDialog()
            }
        }
    )
}

@Composable
fun showDialog(): Boolean {
    var openDialog by remember {
        mutableStateOf(true)
    }
    val context = LocalContext.current
    if (openDialog) {
        AlertDialog(onDismissRequest = { openDialog = false },
            title = { Text(text = "Title") },
            text = { Text(text = "Message") },
            confirmButton = {
                TextButton(onClick = {
                    openDialog = false
                    Toast.makeText(context, "Confirm Click", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    openDialog = false
                    Toast.makeText(context, "Dissmiss Click", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Dismiss")
                }
            }
        )
    }

    return openDialog
}

