package com.example.week8superherociceroneappwb

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import com.example.week8superherociceroneappwb.data.MyAPICall
import com.example.week8superherociceroneappwb.data.Utils
import com.example.week8superherociceroneappwb.data.Utils.APP_PREFERENCES
import com.example.week8superherociceroneappwb.databinding.ActivitySplashScreenBinding
import com.example.week8superherociceroneappwb.modelPOJO.SuperheroCommonInfo
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var heroId: String
    private val superheroCommonInfoArrayList: ArrayList<SuperheroCommonInfo> = ArrayList()
    private val numberOfHeroes = 300

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)

        val existingSuperhero = sharedPreferences.getString("1", "")

        if (existingSuperhero.isNullOrBlank()) {
            showMeetingAlertDialog()
        } else {
            createSuperherosListFromSharedPreferences()
        }
    }

    private fun showMeetingAlertDialog() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Загрузка данных")
            .setMessage("На устройстве отсутсвуют сохраненные данные. Загрузить из интернета?")
            .setCancelable(false)
            .setPositiveButton(R.string.alert_dialog_yes) { dialog, which ->
                superheroRequest()
            }.show()
    }

    private fun createSuperherosListFromSharedPreferences() {
        for (i in 1..numberOfHeroes) {
            val currentSuperheroCommonInfo = loadSuperhero(i.toString())
            if (currentSuperheroCommonInfo != null) {
                superheroCommonInfoArrayList.add(currentSuperheroCommonInfo)
            }
            if (i == numberOfHeroes) {
                startSuperHeroListActivity()
                Toast.makeText(this, "Данные загружены из SharedPreferences", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun superheroRequest() {
        if (isOnline(this)) {
            val retrofit = Retrofit.Builder().baseUrl(Utils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            for (i in 1..numberOfHeroes) {
                heroId = "$i.json"
                val myAPICall = retrofit.create(MyAPICall::class.java)
                val call = myAPICall.getSuperheroCommonInfo(heroId)
                call.enqueue(object : Callback<SuperheroCommonInfo> {
                    override fun onResponse(
                        call: Call<SuperheroCommonInfo>,
                        response: Response<SuperheroCommonInfo>
                    ) {
                        val superheroCommonInfo = response.body()
                        if (superheroCommonInfo != null) {
                            saveCurrentHero(superheroCommonInfo, i.toString())
                            superheroCommonInfoArrayList.add(superheroCommonInfo)
                        }
                        if (i == numberOfHeroes) {
                            runOnUiThread {
                                startSuperHeroListActivity()
                                Toast.makeText(
                                    applicationContext,
                                    "Данные загружены из интернета",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    }

                    override fun onFailure(call: Call<SuperheroCommonInfo>, t: Throwable) {
                        t.printStackTrace()
                    }
                })
            }
        } else {
            MaterialAlertDialogBuilder(this)
                .setTitle("Отсутствует соединение с сетью")
                .setMessage("Проверьте ваще подключение к сети и перезапустите приложение")
                .setCancelable(false)
                .setPositiveButton(R.string.alert_dialog_yes) { dialog, which ->
                    startActivity(Intent(Settings.ACTION_SETTINGS))
                    finish()
                }.show()
        }
    }

    private fun saveCurrentHero(currentSuperheroCommonInfo: SuperheroCommonInfo, key: String) {
        val gson = Gson()
        val stringJson = gson.toJson(currentSuperheroCommonInfo)
        sharedPreferences.edit()
            .putString(key, stringJson)
            .apply()
    }

    private fun loadSuperhero(key: String): SuperheroCommonInfo? {
        var result: SuperheroCommonInfo? = null
        val gson = Gson()
        val stringJson = sharedPreferences.getString(key, "")
        val superheroCommonInfo = gson.fromJson(stringJson, SuperheroCommonInfo::class.java)
        if (superheroCommonInfo != null) {
            result = superheroCommonInfo
        }
        return result
    }

    private fun startSuperHeroListActivity() {
        val intent = Intent(
            this,
            MainActivity::class.java
        )
        val superheroListBundle = Bundle()
        superheroListBundle.putParcelableArrayList(
            Utils.SUPERHERO_LIST_KEY,
            superheroCommonInfoArrayList
        )
        intent.putExtras(superheroListBundle)
        startActivity(intent)
        finish()
    }

    private fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                return true
            }
        }
        return false
    }
}