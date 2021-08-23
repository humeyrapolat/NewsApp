package com.humeyrapolat.newsapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.LOG
import com.humeyrapolat.newsapp.R
import com.humeyrapolat.newsapp.adapter.NewsAdapter
import com.humeyrapolat.newsapp.adapter.NewsClickListener
import com.humeyrapolat.newsapp.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.news_item.view.*


/**
 * @author Hümeyra POLAT
 * @sınce 12.08.2021
 */

class NewsFragment : Fragment() {

    private lateinit var viewModel: NewsViewModel
    private val newsAdapter = NewsAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        viewModel.refreshData()
        news_fragment_recycler.layoutManager = LinearLayoutManager(context)
        news_fragment_recycler.adapter = newsAdapter

        viewModel.news.observe(viewLifecycleOwner, Observer {
            it.let {
                news_fragment_recycler.visibility = View.VISIBLE
                newsAdapter.setNewsListItem(it)
            }
        })
    }
}