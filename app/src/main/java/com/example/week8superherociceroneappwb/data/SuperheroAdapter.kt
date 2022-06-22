package com.example.week8superherociceroneappwb.data

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.week8superherociceroneappwb.App.Companion.router
import com.example.week8superherociceroneappwb.MainActivity
import com.example.week8superherociceroneappwb.R
import com.example.week8superherociceroneappwb.ScreensImplementation
import com.example.week8superherociceroneappwb.fragments.InfoSuperHeroFragment
import com.example.week8superherociceroneappwb.modelPOJO.SuperheroCommonInfo
import com.github.terrakok.cicerone.Cicerone
import com.squareup.picasso.Picasso

class SuperheroAdapter(
    private val superheroCommonInfoArrayList: ArrayList<SuperheroCommonInfo>,
    private val context: Context,
) : RecyclerView.Adapter<SuperheroAdapter.SuperheroViewHolder>() {

    inner class SuperheroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val superheroIconImageView: ImageView = itemView.findViewById(R.id.superheroIconImageView)
        val superheroNameTextView: TextView = itemView.findViewById(R.id.superheroNameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.superhero_item, parent, false)
        return SuperheroViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        val superheroCommonInfo = superheroCommonInfoArrayList[position]

        Picasso
            .get()
            .load(superheroCommonInfo.images.lg)
            .error(R.drawable.error_load_pic)
            .into(holder.superheroIconImageView)

        holder.superheroNameTextView.text = superheroCommonInfo.name

        holder.itemView.setOnClickListener {
            val superheroInfoBundle = Bundle().apply {
                putString(Utils.IMAGE_KEY, superheroCommonInfo.images.lg)
                putString(Utils.NAME_KEY, superheroCommonInfo.name)
                putString(Utils.GENDER_KEY, superheroCommonInfo.appearance.gender)
                putString(Utils.RACE_KEY, superheroCommonInfo.appearance.race)
                putString(Utils.HEIGHT_KEY, superheroCommonInfo.appearance.height.toString())
                putString(Utils.WEIGHT_KEY, superheroCommonInfo.appearance.weight.toString())
                putString(Utils.EYE_COLOR_KEY, superheroCommonInfo.appearance.eyeColor)
                putString(Utils.HAIR_COLOR_KEY, superheroCommonInfo.appearance.hairColor)
                putString(Utils.INTELLIGENCE_KEY, superheroCommonInfo.powerstats.intelligence.toString())
                putString(Utils.STRENGTH_KEY, superheroCommonInfo.powerstats.strength.toString())
                putString(Utils.SPEED_KEY, superheroCommonInfo.powerstats.speed.toString())
                putString(Utils.DURABILITY_KEY, superheroCommonInfo.powerstats.durability.toString())
                putString(Utils.POWER_KEY, superheroCommonInfo.powerstats.power.toString())
                putString(Utils.COMBAT_KEY, superheroCommonInfo.powerstats.combat.toString())
                putString(Utils.FULL_NAME_KEY, superheroCommonInfo.biography.fullName)
                putString(Utils.ALTER_EGOS_KEY, superheroCommonInfo.biography.alterEgos)
                putString(Utils.PLACE_OF_BIRTH_KEY, superheroCommonInfo.biography.placeOfBirth)
                putString(Utils.OCCUPATION_KEY, superheroCommonInfo.work.occupation)
                putString(Utils.BASE_KEY, superheroCommonInfo.work.base)
                putString(Utils.GROUP_AFFILIATION_KEY, superheroCommonInfo.connections.groupAffiliation)
                putString(Utils.RELATIVES_KEY, superheroCommonInfo.connections.relatives)
            }
            router.navigateTo(ScreensImplementation().showInfoSuperheroScreen(superheroInfoBundle))
        }
    }

    override fun getItemCount(): Int {
        return superheroCommonInfoArrayList.size
    }
}