package com.example.herolist

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.herolist.model.HeroesData
import com.example.herolist.model.heroes
import com.example.herolist.repo.HeroesRepo
import com.example.herolist.ui.theme.HeroListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeroListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HeroApp()
                }
            }
        }
    }
}

@Composable
fun HeroTopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(56.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h1
        )
    }
}

/**
 * Функция списка
 */
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HeroApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { HeroTopBar() }
    ) {
        LazyColumn(
            modifier =
            Modifier.background(MaterialTheme.colors.background)
        ) {
            items(heroes) {
                CardHeroes(it)
            }
        }
    }

}

/**
 * Функция карточки
 */
@Composable
fun CardHeroes(heroesRepo: HeroesData, modifier: Modifier = Modifier) {
    Card(
        elevation = 4.dp,
        modifier = modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {
                InfoHeroes(nameHero = heroesRepo.nameHero, desc = heroesRepo.descHero)

            }

            Spacer(Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))

            ) {
                IconHeroes(drawableIcon = heroesRepo.drawableHero)
            }
        }


    }

}

/**
 * Функция иконки отображения
 */
@Composable
fun IconHeroes(@DrawableRes drawableIcon: Int, modifier: Modifier = Modifier) {

    Image(
        painter = painterResource(drawableIcon), contentDescription = null,
        alignment = Alignment.TopCenter,
        contentScale = ContentScale.FillWidth,

        )


}

/**
 * Функция информации о герое
 */
@Composable
fun InfoHeroes(@StringRes nameHero: Int, @StringRes desc: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(
            start = 16.dp,
            top = 8.dp,
            bottom = 16.dp,
            end = 16.dp
        )
    ) {
        Text(
            text = stringResource(nameHero),
            style = MaterialTheme.typography.h6,

            )
        Text(
            text = stringResource(desc),
            style = MaterialTheme.typography.body1,

            )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HeroListTheme(false) {
        HeroApp()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewDark() {
    HeroListTheme(true) {
        HeroApp()
    }
}