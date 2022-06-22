package com.example.week8superherociceroneappwb.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.week8superherociceroneappwb.MainActivity
import com.example.week8superherociceroneappwb.R
import com.example.week8superherociceroneappwb.ScreensImplementation
import com.example.week8superherociceroneappwb.data.SuperheroAdapter
import com.example.week8superherociceroneappwb.data.Utils
import com.example.week8superherociceroneappwb.databinding.FragmentSuperHeroListBinding
import com.example.week8superherociceroneappwb.fragments.contract.HasCustomTitle
import com.example.week8superherociceroneappwb.modelPOJO.SuperheroCommonInfo

class SuperHeroListFragment : Fragment(), HasCustomTitle {

    private lateinit var binding: FragmentSuperHeroListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSuperHeroListBinding.inflate(inflater, container, false)

        val layoutManager = GridLayoutManager(requireContext() as MainActivity, 3)
        val adapter = SuperheroAdapter(getSuperHeroItemList(), requireContext() as MainActivity)

        binding.superheroRecyclerView.adapter = adapter
        binding.superheroRecyclerView.layoutManager = layoutManager

        return binding.root
    }

    override fun getTitleRes(): Int = R.string.superheroes_list_title

    private fun getSuperHeroItemList(): ArrayList<SuperheroCommonInfo> =
        requireArguments().getParcelableArrayList(Utils.SUPERHERO_LIST_KEY)!!

    companion object {
        @JvmStatic
        fun newInstance(superheroItems: ArrayList<SuperheroCommonInfo>): SuperHeroListFragment {
            val args = Bundle().apply {
                putParcelableArrayList(Utils.SUPERHERO_LIST_KEY, superheroItems)
            }
            val fragment = SuperHeroListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}