package com.example.task.data

import AllCurrenciesModel
import com.example.task.constants.UiConstants
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("latest?access_key=" + UiConstants.ACCESS_KEY+"&MXN&format=1")
     fun getAllCurrencies(): Call<AllCurrenciesModel>
}