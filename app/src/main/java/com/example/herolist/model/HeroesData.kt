package com.example.herolist.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class HeroesData
    (
    @StringRes val nameHero: Int,
    @StringRes val descHero: Int,
    @DrawableRes val drawableHero: Int

)
