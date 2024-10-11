package com.example.hh_mock.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.data.model.home.VacancyModel
import com.example.hh_mock.R
import com.example.hh_mock.databinding.FragmentFavoriteBinding
import com.example.hh_mock.ui.FavoriteVacancyStorage
import com.example.hh_mock.ui.adapter_delegate.adapters.VacanciesAdapter
import com.example.hh_mock.ui.home.HomeFragmentDirections
import com.example.hh_mock.ui.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment(), VacanciesAdapter.VacancyClickListener {

    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var favoriteVacancyStorage: FavoriteVacancyStorage
    private val homeViewModel: HomeViewModel by activityViewModels()
    private lateinit var adapter: VacanciesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        favoriteVacancyStorage = FavoriteVacancyStorage(requireContext())
        adapter = VacanciesAdapter()
        adapter.setOnVacancyCLickListener(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.favorites.observe(viewLifecycleOwner) {
            adapter.setItems(it)

            binding.tvNumberOfRepliedVacancies.text =
                requireContext().getString(R.string.RepliedVacancies, it.size)
        }

        binding.rvRepliedVacancies.adapter = adapter

    }

    override fun onVacancyClick(vacancyModel: VacancyModel) {
        val action =
            FavoriteFragmentDirections.actionFavoriteFragmentToDetailedVacancyFragment(vacancyModel)
        findNavController().navigate(action)
    }
}