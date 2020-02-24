package com.example.movies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.model.movies
import kotlinx.coroutines.*
import java.lang.Exception

class MovieFragmentViewModel(val movieRepo: MovieRepository) : ViewModel() {
    private val viewModelJob = Job()


    private val coScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    var movieData = MutableLiveData<List<movies>>()


    init {

        viewModelScope.launch {
            try {
                val response = movieRepo.getAllMovies()
                movieData.value = response
                Log.i("Success", response.toString())
            } catch (ex: Exception) {
                Log.i("Failure", ex.localizedMessage)
            }
        }
    }


}