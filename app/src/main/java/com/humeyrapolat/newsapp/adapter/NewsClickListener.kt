package com.humeyrapolat.newsapp.adapter
import android.view.View
import com.humeyrapolat.newsapp.model.News

/**
 * @author Hümeyra POLAT
 * @sınce 12.08.2021
 */

interface NewsClickListener{
    fun onNewsClicked(news: News, view: View)
}
