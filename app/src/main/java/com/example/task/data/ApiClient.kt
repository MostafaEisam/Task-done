package com.example.task.data

import AllCurrenciesModel
import com.example.task.constants.UiConstants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        private var mApiInterface: ApiInterface
        init {
            val retrofit = Retrofit.Builder()
                .baseUrl(UiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            mApiInterface = retrofit.create(ApiInterface::class.java)

        }
        fun getAllCurrencies(): Call<AllCurrenciesModel>{
            return mApiInterface.getAllCurrencies()
        }
    }
}