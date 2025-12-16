package com.example.listasg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.listasg.ui.theme.ListaSGTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaSGTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {

                    }
                }
            }
        }
    }
}

@Composable
fun ListItem(item: Item, modifier: Modifier = Modifier) {

}

fun VerticalList(items: List<Item>, modifier: Modifier = Modifier) {

}

fun HorizontalList(items: List<Item>, modifier: Modifier = Modifier) {

}

fun ItemsList(items: List<Item>, modifier: Modifier = Modifier) {

}
