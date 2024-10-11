package com.example.toolkit.extensions

import java.text.SimpleDateFormat
import java.util.*

fun formatDateToRussian(inputDate: String): String {

    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val date: Date = inputFormat.parse(inputDate) ?: return ""

    val monthsInRussian = listOf(
        "января", "февраля", "марта", "апреля", "мая", "июня",
        "июля", "августа", "сентября", "октября", "ноября", "декабря"
    )

    val calendar = Calendar.getInstance().apply { time = date }
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val month = calendar.get(Calendar.MONTH)

    return "Опубликовано $day ${monthsInRussian[month]}"
}