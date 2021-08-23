package com.humeyrapolat.newsapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext
/**
 * @author Hümeyra POLAT
 * @sınce 20.08.2021
 */

abstract class BaseViewModel(application : Application) :AndroidViewModel(application),CoroutineScope{

    private val job = Job()
    override val coroutineContext : CoroutineContext
    get() = job + Dispatchers.Main


    //eğer app kapatılırsa context giderse bu iş iptal
    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}