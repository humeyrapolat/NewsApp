package com.humeyrapolat.newsapp.service

import android.app.Application
import android.content.Context
import androidx.room.*
import com.humeyrapolat.newsapp.model.APIResponse
import com.humeyrapolat.newsapp.model.News
import com.humeyrapolat.newsapp.util.Converters
import kotlinx.coroutines.internal.synchronized

/**
 * @author Hümeyra POLAT
 * @sınce 23.08.2021
 */

@Database(entities = [News::class], version = 1)
@TypeConverters(Converters::class)
abstract class NewsDatabase (): RoomDatabase() {

    abstract fun newsDao(): NewsDao

    companion object {

        //Bu sınıf içinde oluşturduğumuz tek değişken
        @Volatile
        private var instance: NewsDatabase? = null
        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: kotlin.synchronized(lock) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext, NewsDatabase::class.java, "newsdatabase"
        ).build()
    }


}