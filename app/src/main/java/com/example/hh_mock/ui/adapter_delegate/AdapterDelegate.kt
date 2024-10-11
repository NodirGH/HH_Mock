package com.example.hh_mock.ui.adapter_delegate

import android.content.Context
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.data.local.DisplayableItem
import com.example.data.model.home.AllHeadersModel
import com.example.data.model.home.AllVacancyModel
import com.example.hh_mock.R
import com.example.hh_mock.databinding.ItemSearchBinding
import com.example.hh_mock.databinding.ItemVacancyWithHeaderBinding
import com.example.hh_mock.ui.adapter_delegate.adapters.HeaderAdapter
import com.example.hh_mock.ui.adapter_delegate.adapters.VacanciesAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun headerAdapterDelegate() = adapterDelegateViewBinding<AllHeadersModel, DisplayableItem, ItemSearchBinding>(
    {layoutInflater, root -> ItemSearchBinding.inflate(layoutInflater, root, false) }
) {
    bind {

        val headerAdapter = HeaderAdapter()
        binding.rvHeaders.apply {
            adapter = headerAdapter
            layoutManager = LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
            itemAnimator = DefaultItemAnimator()
        }
        headerAdapter.setItems(item.headers)
        binding.etSearch.hint = this.context.getString(R.string.Search)
        binding.ivFilter.setOnClickListener {

        }

    }
}

fun vacanciesAdapterDelegate(vacanciesAdapter: VacanciesAdapter) = adapterDelegateViewBinding<AllVacancyModel, DisplayableItem, ItemVacancyWithHeaderBinding>(
    {layoutInflater, root -> ItemVacancyWithHeaderBinding.inflate(layoutInflater, root, false) }
) {
    bind {

        binding.rvVacancies.apply {
            adapter = vacanciesAdapter
            layoutManager = LinearLayoutManager(itemView.context, RecyclerView.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
        }

        vacanciesAdapter.setItems(item.vacancies)


    }
}