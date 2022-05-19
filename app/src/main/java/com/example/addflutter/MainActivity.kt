package com.example.addflutter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.addflutter.components.SimpleButtonComponent
import com.example.addflutter.ui.theme.AddFlutterTheme
import io.flutter.embedding.android.FlutterActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddFlutterTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LaunchFlutterButton()
                }
            }
        }
    }
}

@Composable
fun LaunchFlutterButton() {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SimpleButtonComponent(
            onClick = {
                context.startActivity(
                    FlutterActivity
                        .withCachedEngine(AddFlutterApplication.FLUTTER_ENGINE_NAME)
                        .build(context)
                )
            },
            text = "Launch Flutter Activity"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AddFlutterTheme {
        LaunchFlutterButton()
    }
}