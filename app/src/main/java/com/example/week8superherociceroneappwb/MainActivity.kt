package com.example.week8superherociceroneappwb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.week8superherociceroneappwb.App.Companion.navigatorHolder
import com.example.week8superherociceroneappwb.App.Companion.router
import com.example.week8superherociceroneappwb.data.Utils
import com.example.week8superherociceroneappwb.databinding.ActivityMainBinding
import com.example.week8superherociceroneappwb.fragments.AboutAppFragment
import com.example.week8superherociceroneappwb.fragments.contract.HasCustomTitle
import com.example.week8superherociceroneappwb.modelPOJO.SuperheroCommonInfo
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val navigator = AppNavigator(this, R.id.fragmentContainer)

    private val currentFragment: Fragment
        get() = supportFragmentManager.findFragmentById(R.id.fragmentContainer)!!

    private val fragmentListener = object : FragmentManager.FragmentLifecycleCallbacks() {
        override fun onFragmentViewCreated(
            fm: FragmentManager,
            f: Fragment,
            v: View,
            savedInstanceState: Bundle?
        ) {
            super.onFragmentViewCreated(fm, f, v, savedInstanceState)
            updateUi()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val bundle = intent.extras

        if (bundle != null && savedInstanceState == null) {
            val superheroItems: ArrayList<SuperheroCommonInfo> =
                bundle.getParcelableArrayList(Utils.SUPERHERO_LIST_KEY)!!

            router.navigateTo(ScreensImplementation().showSuperheroListScreen(superheroItems))
        }
        supportFragmentManager.registerFragmentLifecycleCallbacks(fragmentListener, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        supportFragmentManager.unregisterFragmentLifecycleCallbacks(fragmentListener)
    }

    private fun updateUi() {
        val fragment = currentFragment

        if (fragment is HasCustomTitle) {
            binding.toolbar.title = getString(fragment.getTitleRes())
        }
        binding.toolbar.menu.findItem(R.id.about).isVisible = fragment !is AboutAppFragment
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.about) {
            router.navigateTo(ScreensImplementation().showAboutAppScreen())
        }
        return true
    }
}