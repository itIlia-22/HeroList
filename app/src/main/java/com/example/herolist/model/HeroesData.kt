package com.example.herolist.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.herolist.R

data class HeroesData
    (
    @StringRes val nameHero: Int,
    @StringRes val descHero: Int,
    @DrawableRes val drawableHero: Int

)

val heroes = listOf<HeroesData>(
    HeroesData(nameHero = R.string.hero1, R.string.description1, R.drawable.android_superhero1),
    HeroesData(nameHero = R.string.hero2, R.string.description2, R.drawable.android_superhero2),
    HeroesData(nameHero = R.string.hero3, R.string.description3, R.drawable.android_superhero3),
    HeroesData(nameHero = R.string.hero4, R.string.description4, R.drawable.android_superhero4),
    HeroesData(nameHero = R.string.hero5, R.string.description5, R.drawable.android_superhero5),
    HeroesData(nameHero = R.string.hero6, R.string.description6, R.drawable.android_superhero6)
)

