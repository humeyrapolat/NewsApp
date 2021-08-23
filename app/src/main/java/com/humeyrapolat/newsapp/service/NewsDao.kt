package com.humeyrapolat.newsapp.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.humeyrapolat.newsapp.model.News
/**
 * @author Hümeyra POLAT
 * @sınce 23.08.2021
 */


@Dao
interface NewsDao {

    //DATA ACCESS OBJECT
    @Insert
    suspend fun insertAll(vararg news: News): List<Long>

    /*
    insert --> Insert into
    suspend --> coroutine, pause & resume
    vararg --> çoklu haber objem
    List<Long> --> primary keyler

     */

    @Query("SELECT * FROM News",)
    suspend fun getAllNews(): List<News>

    @Query("SELECT * FROM News WHERE uuıd = :newsId ")
    suspend fun getNew(newsId : Int): News

    @Query("DELETE FROM News")
    suspend fun deleteAllNews()
}