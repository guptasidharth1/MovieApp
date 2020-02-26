package com.example.movies.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movies.MovieChatRepository
import com.example.movies.MovieFragmentViewModel
import com.example.movies.MovieRepository

class MovieChatFragmentViewModelFactory: ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieChatFragmentViewModel(
            MovieChatRepository()
        ) as T
    }
}