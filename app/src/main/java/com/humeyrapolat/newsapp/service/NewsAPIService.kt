package com.humeyrapolat.newsapp.service

import com.humeyrapolat.newsapp.model.News
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * @author Hümeyra POLAT
 * @sınce 12.08.2021
 */

class NewsAPIService {
    //https://currentsapi.services/
    //
    private val BASE_URL = "https://api.currentsapi.services/"

     val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(NewsAPI::class.java)

}