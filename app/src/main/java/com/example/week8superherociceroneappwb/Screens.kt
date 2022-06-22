package com.example.week8superherociceroneappwb

import android.os.Bundle
import com.example.week8superherociceroneappwb.fragments.InfoSuperHeroFragment
import com.example.week8superherociceroneappwb.modelPOJO.SuperheroCommonInfo
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen


interface Screens {
    fun showSuperheroListScreen(superheroItems: ArrayList<SuperheroCommonInfo>): Screen
    fun showInfoSuperheroScreen(superheroInfoBundle: Bundle): Screen
    fun showAboutAppScreen(): Screen
}