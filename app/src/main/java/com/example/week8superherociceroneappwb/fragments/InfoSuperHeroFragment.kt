package com.example.week8superherociceroneappwb.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.week8superherociceroneappwb.R
import com.example.week8superherociceroneappwb.data.Utils
import com.example.week8superherociceroneappwb.databinding.FragmentInfoSuperHeroBinding
import com.example.week8superherociceroneappwb.fragments.contract.HasCustomTitle
import com.squareup.picasso.Picasso

class InfoSuperHeroFragment : Fragment(), HasCustomTitle {

    private lateinit var binding: FragmentInfoSuperHeroBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoSuperHeroBinding.inflate(inflater, container, false)
        setSuperheroInfo()
        return binding.root
    }

    override fun getTitleRes(): Int = R.string.superhero_info_title

    private fun setSuperheroInfo() {
        val bundle = getSuperheroInfoBundle()
        if (bundle != null) {

            val url = bundle.getString(Utils.IMAGE_KEY)
            Picasso.get().load(url).error(R.drawable.error_load_pic)
                .into(binding.superheroIconImageView)

            if (bundle.getString(Utils.NAME_KEY) != null && bundle.getString(Utils.NAME_KEY) != "-") {
                binding.setNameTextView.text = bundle.getString(Utils.NAME_KEY)
            } else {
                binding.setNameTextView.text = Utils.NO_DATA
            }

            if (bundle.getString(Utils.GENDER_KEY) != null && bundle.getString(Utils.GENDER_KEY) != "-") {
                binding.setGenderTextView.text = bundle.getString(Utils.GENDER_KEY)
            } else {
                binding.setGenderTextView.text = Utils.NO_DATA
            }

            if (bundle.getString(Utils.RACE_KEY) != null && bundle.getString(Utils.RACE_KEY) != "-") {
                binding.setRaceTextView.text = bundle.getString(Utils.RACE_KEY)
            } else {
                binding.setRaceTextView.text = Utils.NO_DATA
            }

            if (bundle.getString(Utils.HEIGHT_KEY) != null && bundle.getString(Utils.HEIGHT_KEY) != "-") {
                binding.setHeightTextView.text = bundle.getString(Utils.HEIGHT_KEY)
            } else {
                binding.setHeightTextView.text = Utils.NO_DATA
            }

            if (bundle.getString(Utils.WEIGHT_KEY) != null && bundle.getString(Utils.WEIGHT_KEY) != "-") {
                binding.setWeightTextView.text = bundle.getString(Utils.WEIGHT_KEY)
            } else {
                binding.setWeightTextView.text = Utils.NO_DATA
            }

            if (bundle.getString(Utils.EYE_COLOR_KEY) != null && bundle.getString(Utils.EYE_COLOR_KEY) != "-") {
                binding.setEyeColorTextView.text = bundle.getString(Utils.EYE_COLOR_KEY)
            } else {
                binding.setEyeColorTextView.text = Utils.NO_DATA
            }

            if (bundle.getString(Utils.HAIR_COLOR_KEY) != null && bundle.getString(Utils.HAIR_COLOR_KEY) != "-") {
                binding.setHairColorTextView.text = bundle.getString(Utils.HAIR_COLOR_KEY)
            } else {
                binding.setHairColorTextView.text = Utils.NO_DATA
            }

            if (bundle.getString(Utils.INTELLIGENCE_KEY) != null && bundle.getString(Utils.INTELLIGENCE_KEY) != "-") {
                binding.setIntelligenceTextView.text = bundle.getString(Utils.INTELLIGENCE_KEY)
            } else {
                binding.setIntelligenceTextView.text = Utils.NO_DATA
            }

            if (bundle.getString(Utils.STRENGTH_KEY) != null && bundle.getString(Utils.STRENGTH_KEY) != "-") {
                binding.setStrengthTextView.text = bundle.getString(Utils.STRENGTH_KEY)
            } else {
                binding.setStrengthTextView.text = Utils.NO_DATA
            }

            if (bundle.getString(Utils.SPEED_KEY) != null && bundle.getString(Utils.SPEED_KEY) != "-") {
                binding.setSpeedTextView.text = bundle.getString(Utils.SPEED_KEY)
            } else {
                binding.setSpeedTextView.text = Utils.NO_DATA
            }

            if (bundle.getString(Utils.DURABILITY_KEY) != null && bundle.getString(Utils.DURABILITY_KEY) != "-") {
                binding.setDurabilityTextView.text = bundle.getString(Utils.DURABILITY_KEY)
            } else {
                binding.setDurabilityTextView.text = Utils.NO_DATA
            }

            if (bundle.getString(Utils.POWER_KEY) != null && bundle.getString(Utils.POWER_KEY) != "-") {
                binding.setPowerTextView.text = bundle.getString(Utils.POWER_KEY)
            } else {
                binding.setPowerTextView.text = Utils.NO_DATA
            }

            if (bundle.getString(Utils.COMBAT_KEY) != null && bundle.getString(Utils.COMBAT_KEY) != "-") {
                binding.setCombatTextView.text = bundle.getString(Utils.COMBAT_KEY)
            } else {
                binding.setCombatTextView.text = Utils.NO_DATA
            }

            if (bundle.getString(Utils.FULL_NAME_KEY) != null && bundle.getString(Utils.FULL_NAME_KEY) != "-") {
                binding.setFullNameTextView.text = bundle.getString(Utils.FULL_NAME_KEY)
            } else {
                binding.setFullNameTextView.text = Utils.NO_DATA
            }

            if (bundle.getString(Utils.ALTER_EGOS_KEY) != null && bundle.getString(Utils.ALTER_EGOS_KEY) != "-") {
                binding.setAlterEgosTextView.text = bundle.getString(Utils.ALTER_EGOS_KEY)
            } else {
                binding.setAlterEgosTextView.text = Utils.NO_DATA
            }

            if (bundle.getString(Utils.PLACE_OF_BIRTH_KEY) != null && bundle.getString(Utils.PLACE_OF_BIRTH_KEY) != "-") {
                binding.setPlaceOfBirthTextView.text = bundle.getString(Utils.PLACE_OF_BIRTH_KEY)
            } else {
                binding.setPlaceOfBirthTextView.text = Utils.NO_DATA
            }

            if (bundle.getString(Utils.OCCUPATION_KEY) != null && bundle.getString(Utils.OCCUPATION_KEY) != "-") {
                binding.setOccupationTextView.text = bundle.getString(Utils.OCCUPATION_KEY)
            } else {
                binding.setOccupationTextView.text = Utils.NO_DATA
            }

            if (bundle.getString(Utils.BASE_KEY) != null && bundle.getString(Utils.BASE_KEY) != "-") {
                binding.setBaseTextView.text = bundle.getString(Utils.BASE_KEY)
            } else {
                binding.setBaseTextView.text = Utils.NO_DATA
            }

            if (bundle.getString(Utils.GROUP_AFFILIATION_KEY) != null && bundle.getString(Utils.GROUP_AFFILIATION_KEY) != "-") {
                binding.setGroupAffiliationTextView.text = bundle.getString(Utils.GROUP_AFFILIATION_KEY)
            } else {
                binding.setGroupAffiliationTextView.text = Utils.NO_DATA
            }

            if (bundle.getString(Utils.RELATIVES_KEY) != null && bundle.getString(Utils.RELATIVES_KEY) != "-") {
                binding.setRelativesTextView.text = bundle.getString(Utils.RELATIVES_KEY)
            } else {
                binding.setRelativesTextView.text = Utils.NO_DATA
            }
        }
    }

    private fun getSuperheroInfoBundle(): Bundle? =
        requireArguments().getBundle(Utils.SUPERHERO_INFO_KEY)
    
    companion object{
        @JvmStatic
        fun newInstance(superheroInfoBundle: Bundle): InfoSuperHeroFragment{
            val args = Bundle().apply {
                putBundle(Utils.SUPERHERO_INFO_KEY, superheroInfoBundle)
            }
            val fragment = InfoSuperHeroFragment()
            fragment.arguments = args
            return fragment
        }
    }
}