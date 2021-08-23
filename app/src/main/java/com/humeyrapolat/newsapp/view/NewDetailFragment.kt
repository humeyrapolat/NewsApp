package com.humeyrapolat.newsapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.humeyrapolat.newsapp.R
import com.humeyrapolat.newsapp.databinding.FragmentNewDetailBinding
import com.humeyrapolat.newsapp.model.News
import com.humeyrapolat.newsapp.viewmodel.NewDetailViewModel

/**
 * @author Hümeyra POLAT
 * @sınce 12.08.2021
 */

class NewDetailFragment : Fragment() {

    private lateinit var viewModel: NewDetailViewModel
    private lateinit var dataBinding: FragmentNewDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_new_detail, container, false
        )
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(NewDetailViewModel::class.java)


        arguments?.let {
            viewModel.newLiveData.value = it.getSerializable("newsItem") as News
            dataBinding.selectedNews =viewModel.newLiveData.value
        }


    }

}