package com.humeyrapolat.newsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.humeyrapolat.newsapp.model.APIResponse
import com.humeyrapolat.newsapp.model.News
import com.humeyrapolat.newsapp.service.NewsAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author Hümeyra POLAT
 * @sınce 12.08.2021
 */

class NewDetailViewModel : ViewModel() {

    val newLiveData = MutableLiveData<News>()


}