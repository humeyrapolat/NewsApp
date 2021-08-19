package com.humeyrapolat.newsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.humeyrapolat.newsapp.model.APIResponse
import com.humeyrapolat.newsapp.model.News
import com.humeyrapolat.newsapp.service.NewsAPIService
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author Hümeyra POLAT
 * @sınce 12.08.2021
 */

class NewsViewModel :ViewModel(){

    private val newsAPIService = NewsAPIService()
    private val disposible = CompositeDisposable()
    val news = MutableLiveData<List<News>>()

    fun refreshData(){
        getDataFromApi()
    }


    private fun getDataFromApi(){
        disposible.add(
            newsAPIService.api.getNews()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object  : DisposableSingleObserver<APIResponse>(){
                    override fun onSuccess(t: APIResponse) {
                        news.value =t.news
                    }

                    override fun onError(e: Throwable) {
                    }

                })
        )
    }

}