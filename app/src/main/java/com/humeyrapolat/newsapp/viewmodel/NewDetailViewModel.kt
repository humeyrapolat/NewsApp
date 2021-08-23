package com.humeyrapolat.newsapp.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.humeyrapolat.newsapp.model.APIResponse
import com.humeyrapolat.newsapp.model.News
import com.humeyrapolat.newsapp.service.NewsAPIService
import com.humeyrapolat.newsapp.service.NewsDatabase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import java.util.*

/**
 * @author Hümeyra POLAT
 * @sınce 12.08.2021
 */

class NewDetailViewModel(application: Application) : BaseViewModel(application) {

    val newLiveData = MutableLiveData<News>()
}