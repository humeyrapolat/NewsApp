package com.humeyrapolat.newsapp.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.humeyrapolat.newsapp.R
import com.humeyrapolat.newsapp.databinding.NewsItemBinding
import com.humeyrapolat.newsapp.model.News
import com.humeyrapolat.newsapp.view.NewsFragmentDirections
import kotlinx.android.synthetic.main.news_item.view.*

/**
 * @author Hümeyra POLAT
 * @sınce 12.08.2021
 */
class NewsAdapter(var newsList: ArrayList<News>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(), NewsClickListener {


    class NewsViewHolder(var view: NewsItemBinding) : RecyclerView.ViewHolder(view.root) {
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.news_item, parent, false)
        val view = DataBindingUtil.inflate<NewsItemBinding>(
            inflater, R.layout.news_item,
            parent, false
        )
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        holder.view.news = newsList[position]
        holder.view.listener = this
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun setNewsListItem(list: List<News>) {
        newsList.clear()
        newsList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onNewsClicked(news: News, view: View) {

        val action = NewsFragmentDirections.actionNewsFragmentToNewDetailFragment2(news)
        Navigation.findNavController(view).navigate(action,)
    }

}