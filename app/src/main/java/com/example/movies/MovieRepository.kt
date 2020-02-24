package com.example.movies

import android.util.Log
import com.example.movies.model.MovieResponse
import com.example.movies.model.movies
import com.example.movies.view.MovieApi
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository() {

    var allMovieList = listOf<movies>()

    suspend fun getAllMovies(): List<movies> {

        return withContext(Dispatchers.IO) {

            val result = async {
                MovieApi.retrofitservice.getPopularMovies("cdd99989813fed4e37718a796236c5f6", 1)
            }
            return@withContext prepareList(result.await())

        }

    }

    private fun prepareList(response: MovieResponse) = response.movies


}