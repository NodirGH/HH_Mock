package com.example.data.remote.service

import android.content.Context
import com.example.data.remote.responses.HHMockDataResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Inject

class HomeService @Inject constructor(val context: Context){

    fun readMockDataFromAssets(): HHMockDataResponse? {
        return try {
            val inputStream = context.assets.open("mock.json")
            val reader = BufferedReader(InputStreamReader(inputStream))

            val gson = Gson()
            val type = object : TypeToken<HHMockDataResponse>() {}.type
            val mockData: HHMockDataResponse = gson.fromJson(reader, type)

            reader.close()

            mockData
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}