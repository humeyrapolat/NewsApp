package com.humeyrapolat.newsapp.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.humeyrapolat.newsapp.model.APIResponse
import com.humeyrapolat.newsapp.model.News
import com.humeyrapolat.newsapp.service.NewsAPIService
import com.humeyrapolat.newsapp.service.NewsDatabase
import com.humeyrapolat.newsapp.util.CustomSharedPreferences
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

/**
 * @author Hümeyra POLAT
 * @sınce 12.08.2021
 */

class NewsViewModel(application: Application) : BaseViewModel(application) {

    private val newsAPIService = NewsAPIService()
    private val disposible = CompositeDisposable()
    val news = MutableLiveData<List<News>>()

    private var customPreferences = CustomSharedPreferences(getApplication())
    private val refreshTime = 0.1 * 60 * 1000 * 1000 * 1000L


    fun refreshData() {
        val updateTime = customPreferences.getTime()
        if (updateTime != null && updateTime != 0L && System.nanoTime() - updateTime < refreshTime) {
            getDataFromSQLite()
        } else {
            getDataFromApi()
        }
    }


    private fun getDataFromSQLite() {
        launch {
            val news = NewsDatabase(getApplication()).newsDao().getAllNews()
            displayNews(news)
        }
    }

    private fun getDataFromApi() {
        disposible.add(
            newsAPIService.api.getNews()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<APIResponse>() {
                    override fun onSuccess(t: APIResponse) {
                        storeSQLite(t.news!!)
                    }

                    override fun onError(e: Throwable) {
                    }

                })
        )
    }

    private fun displayNews(newsList: List<News>) {
        news.value = newsList
    }

    private fun storeSQLite(newsList: List<News>) {
        launch {
            val dao = NewsDatabase(getApplication()).newsDao()
            dao.deleteAllNews()
            val listLong = dao.insertAll(*newsList.toTypedArray()) //diziden tek tek hale
            var i = 0
            while (i < newsList.size) {
                newsList[i].uuıd = listLong[i].toInt()
                i = i + 1
            }
            displayNews(newsList)
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposible.clear()
    }
}