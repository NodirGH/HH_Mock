package com.example.hh_mock.ui.adapter_delegate.adapters

import com.example.data.local.DisplayableItem
import com.example.hh_mock.ui.adapter_delegate.headerAdapterDelegate
import com.example.hh_mock.ui.adapter_delegate.vacanciesAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class  MainAdapter(vacanciesAdapter: VacanciesAdapter): ListDelegationAdapter<List<DisplayableItem>>(
    headerAdapterDelegate(),
    vacanciesAdapterDelegate(vacanciesAdapter)
)