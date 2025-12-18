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
        var series = mutableListOf<Series>(
            Series(
                title = getString(R.string.maomao),
                image =
                    R.drawable.kusuriya_no_hitorigoto_full_4470711_304041734,
                description = getString(R.string.maomao_description)
            ),
            Series(title = getString(R.string.berserk),
                image = R.drawable._3752_8,
                description = getString(R.string.berserk_drescription)
            ),
            Series(title = getString(R.string.ghost_in_the_shell),
                image = R.drawable._549,
                description = getString(R.string.ghost_description)
            ),
            Series(
                title = getString(R.string.hajime_no_ippo),
                image = R.drawable._6255,
                description = getString(R.string.hajime_no_ippo_drescription)
            ),
            Series(
                title = getString(R.string.neon_genesis_evangelion),
                image = R.drawable._0350_6,
                description = getString(R.string.evangelion_description)
            ),
            Series(
                title = getString(R.string.shingeki_no_kyojin),
                image = R.drawable._67440_18,
                description = getString(R.string.shingeki_description)
            ),
            Series(
                title = getString(R.string.bocchi),
                image = R.drawable._815659475239,
                description = getString(R.string.bocchi_description)
            ),
            Series(
                title = getString(R.string.yu_gi_oh),
                image = R.drawable._13561_1,
                description = getString(R.string.yu_gi_drescription)
            ),
            Series(
                title = getString(R.string.frieren),
                image = R.drawable._4087339d8ffc,
                description = getString(R.string.frieren_description)
            ),
            Series(
                title = getString(R.string.devilman),
                image = R.drawable._4701_1,
                description = getString(R.string.devilman_description)
            ),
            Series(
                title = getString(R.string.mirai_nikki),
                image = R.drawable._49827_13,
                description = getString(R.string.marai_nikki_description)
            ),
            Series(
                title = getString(R.string.sao),
                image = R.drawable._59640_17,
                description = getString(R.string.sao_description)
            ),
            Series(
                title = getString(R.string.ginga),
                image = R.drawable._2018679,
                description = getString(R.string.ginga_description)
            ),
            Series(
                title = getString(R.string.hellsing),
                image = R.drawable._63688_3,
                description = getString(R.string.hellsing_description)
            ),
            Series(
                title = getString(R.string.bunny),
                image = R.drawable._bb31700962d2,
                description = getString(R.string.bunny_description)
            ),
            Series(
                title = getString(R.string.fate),
                image = R.drawable._9151_7,
                description = getString(R.string.fate_description)
            ),
            Series(
                title = getString(R.string.darling),
                image = R.drawable._37017_7,
                description = getString(R.string.darling_drescription)
            ),
            Series(
                title = getString(R.string.citrus),
                image = R.drawable._84e60b3686ba,
                description = getString(R.string.citrus_description)
            ),
            Series(
                title = getString(R.string.full_metal),
                image = R.drawable._d72201461e40,
                description = getString(R.string.full_metal_description)
            ),
            Series(
                title = getString(R.string.gantz),
                image = R.drawable._8916_6,
                description = getString(R.string.gantz)
            ),
            Series(
                title = getString(R.string.vinland),
                image = R.drawable._1cd8d6549c91,
                description = getString(R.string.vinland_description)
            ),
            Series(
                title = getString(R.string.kill),
                image = R.drawable._72074_7,
                description = getString(R.string.kill_description)
            ),
            Series(
                title = getString(R.string.bleach),
                image = R.drawable._4796_14,
                description = getString(R.string.bleach_description)
            ),
            Series(
                title = getString(R.string.banana),
                image = R.drawable._b90a3114aa4b,
                description = getString(R.string.banana_description)
            ),
            Series(
                title = getString(R.string.ghoul),
                image = R.drawable._bb66c6d13c86,
                description = getString(R.string.ghoul_description)
            )

        )
        setContent {
            ListaSGTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {
                        SeriesList(series)
                    }
                }
            }
        }
    }
}

@Composable
fun SeriesCard(series: Series, modifier: Modifier = Modifier) {
    var visible by remember {
        mutableStateOf(false)
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
