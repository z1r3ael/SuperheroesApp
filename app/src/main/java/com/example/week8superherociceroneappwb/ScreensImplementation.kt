package com.example.week8superherociceroneappwb

import android.os.Bundle
import com.example.week8superherociceroneappwb.fragments.AboutAppFragment
import com.example.week8superherociceroneappwb.fragments.InfoSuperHeroFragment
import com.example.week8superherociceroneappwb.fragments.SuperHeroListFragment
import com.example.week8superherociceroneappwb.modelPOJO.SuperheroCommonInfo
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ScreensImplementation : Screens {

    override fun showSuperheroListScreen(superheroItems: ArrayList<SuperheroCommonInfo>): Screen =
        FragmentScreen { SuperHeroListFragment.newInstance(superheroItems) }

    override fun showInfoSuperheroScreen(superheroInfoBundle: Bundle): Screen =
        FragmentScreen { InfoSuperHeroFragment.newInstance(superheroInfoBundle) }

    override fun showAboutAppScreen(): Screen = FragmentScreen { AboutAppFragment() }

}