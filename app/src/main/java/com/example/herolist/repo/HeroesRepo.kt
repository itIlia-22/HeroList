package com.example.herolist.repo

import com.example.herolist.R
import com.example.herolist.model.HeroesData

class HeroesRepo {
    val heroes = listOf<HeroesData>(
        HeroesData(nameHero = R.string.hero1, R.string.description1, R.drawable.android_superhero1),
        HeroesData(nameHero = R.string.hero2, R.string.description2, R.drawable.android_superhero2),
        HeroesData(nameHero = R.string.hero3, R.string.description3, R.drawable.android_superhero3),
        HeroesData(nameHero = R.string.hero4, R.string.description4, R.drawable.android_superhero4),
        HeroesData(nameHero = R.string.hero5, R.string.description5, R.drawable.android_superhero5),
        HeroesData(nameHero = R.string.hero6, R.string.description6, R.drawable.android_superhero6)
    )

}