package com.humeyrapolat.newsapp.service

import com.humeyrapolat.newsapp.model.APIResponse
import com.humeyrapolat.newsapp.model.News
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Hümeyra POLAT
 * @sınce 12.08.2021
 */

interface NewsAPI {

    //v1/latest/-news
    //
    @GET("v1/latest-news")
    //hangi fonksiyon içine atanacağını söyleriz :
    //Verilerin nasıl çağırılacağını söylememiz lazım Call<List<News>> yapabilirdik
    //retrofitte bunu kullandık
    //bu sefer RXJava kullanıyoruz :
    // Observeble = internetteki verileri devamlı şekilde güncellememiz ve almamız gerektiğinde kullanırız
    //Single = internetttei veriyi bir defa ve garanti şekilde  almamız gerektiğinde kullanırız
    fun getNews(
        @Query("apiKey") apiKey: String = "6FWO--Wyx1HNfr6Xxq8Hj0sR3TOV15zarudC3YwxWWK5s83q",
        @Query("language") language: String = "fr"
    ): Single<APIResponse>
}