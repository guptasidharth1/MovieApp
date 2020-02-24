package com.example.movies

import android.graphics.Movie
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MovieFragmentViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieFragmentViewModel(
            MovieRepository()
        ) as T
    }
}