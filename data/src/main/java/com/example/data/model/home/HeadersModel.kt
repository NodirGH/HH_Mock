package com.example.data.model.home

import com.example.data.local.DisplayableItem

data class HeadersModel(
    val id: String = "",
    val title: String = "",
    val link: String = "",
    val buttonText: String = "",
) : DisplayableItem