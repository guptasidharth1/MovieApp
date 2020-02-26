package com.example.movies.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.MovieFragmentViewModel
import com.example.movies.MovieFragmentViewModelFactory
import com.example.movies.R
import com.example.movies.model.movies
import kotlinx.android.synthetic.main.chatrecyclerlayout.*
import kotlinx.android.synthetic.main.fraglay.*

class MovieChatFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.chatrecyclerlayout, container, false)
    }

    private lateinit var chatMoviesAdapter: MovieChatAdaptor


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initmodels()
        initadaptors()
    }

    private lateinit var view: MovieChatFragmentViewModel
    private fun initmodels() {
        view = ViewModelProviders.of(this, MovieChatFragmentViewModelFactory())
            .get(MovieChatFragmentViewModel::class.java)
        observe()
    }

    private fun initadaptors() {
        chat_recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
        val list =ArrayList<Pair<Int, String>>()
        chatMoviesAdapter =  MovieChatAdaptor(list)
        chat_recyclerView.adapter = chatMoviesAdapter
    }

    private fun observe() {
        view.movieChatData.observe(viewLifecycleOwner, Observer<ArrayList<Pair<Int, String>>> { chatData ->
            chatMoviesAdapter.updateChatData(chatData)})
    }

}

