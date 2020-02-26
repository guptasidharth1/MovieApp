package com.example.movies.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.MovieChatRepository
import com.example.movies.model.movies
import kotlinx.coroutines.launch
import java.lang.Exception

class MovieChatFragmentViewModel(val movieChatRepo: MovieChatRepository): ViewModel() {
    var movieChatData = MutableLiveData<ArrayList<Pair<Int, String>>>()

    init {
        viewModelScope.launch {
            try {
                val response = movieChatRepo.movieChatDetails()
                movieChatData.value = response
                Log.i("Success", response.toString())
            } catch (ex: Exception) {
                Log.i("Failure", ex.localizedMessage)
            }
        }
    }

}