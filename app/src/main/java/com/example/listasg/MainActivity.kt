package com.example.listasg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.window.core.layout.WindowSizeClass
import com.example.listasg.ui.theme.ListaSGTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaSGTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {
                        SeriesList(listOf(
                            Series(
                                "Ejemplo", R.drawable.ic_launcher_foreground,
                                description = "Esta es una imagen de ejemplo para ver que las animaciones funcionan"
                            ),
                            Series(
                                "Ejemplo", R.drawable.ic_launcher_foreground,
                                description = "Esta es una imagen de ejemplo para ver que las animaciones funcionan"
                            ),
                            Series(
                                "Ejemplo", R.drawable.ic_launcher_foreground,
                                description = "Esta es una imagen de ejemplo para ver que las animaciones funcionan"
                            ),
                            Series(
                                "Ejemplo", R.drawable.ic_launcher_foreground,
                                description = "Esta es una imagen de ejemplo para ver que las animaciones funcionan"
                            ),
                            Series(
                                "Ejemplo", R.drawable.ic_launcher_foreground,
                                description = "Esta es una imagen de ejemplo para ver que las animaciones funcionan"
                            ),
                            Series(
                                "Ejemplo", R.drawable.ic_launcher_foreground,
                                description = "Esta es una imagen de ejemplo para ver que las animaciones funcionan"
                            )
                        ))

                    }
                }
            }
        }
    }
}

@Composable
fun SeriesCard(series: Series, modifier: Modifier = Modifier) {
    var visible by remember {
        mutableStateOf(true)
    }

    Card(onClick = { visible = !visible }) {
        Column() {
            Text(series.title)
            Image(painterResource(series.image), contentDescription = null)
            AnimatedVisibility(visible) {
                Text(series.description)
            }
        }
    }
}

@Composable
fun VerticalSeriesList(series: List<Series>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(series) {
            SeriesCard(it)
        }
    }
}

@Composable
fun HorizontalSeriesList(series: List<Series>, modifier: Modifier = Modifier) {
    LazyRow(modifier = modifier) {
        items(series) {
            SeriesCard(it)
        }
    }
}

@Composable
fun SeriesList(series: List<Series>, modifier: Modifier = Modifier,
               windowSizeClass: WindowSizeClass = currentWindowAdaptiveInfo(supportLargeAndXLargeWidth = true).windowSizeClass) {
    val useHorizonalList = windowSizeClass.isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND)
    if (useHorizonalList) {
        HorizontalSeriesList(series, modifier)
    } else {
        VerticalSeriesList(series, modifier)
    }
}
