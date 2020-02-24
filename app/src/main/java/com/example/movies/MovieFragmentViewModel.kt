package com.example.movies

import android.util.Log
import androidx.lifecycle.LiveData
import retrofit2.Callback

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.model.MovieResponse
import com.example.movies.model.movies
import com.example.movies.view.MovieApi
import com.example.movies.view.MoviesAdapter
import retrofit2.Call
import retrofit2.Response

class MovieFragmentViewModel() :ViewModel(){

    var movieData= MutableLiveData<List<movies>>()

    var test : String =""

    init{
        MovieApi.retrofitservice.getPopularMovies("cdd99989813fed4e37718a796236c5f6",2).enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>?, t: Throwable?) {
                Log.i("Failure", "fsdfjjsdofjisdjf")
            }

            override fun onResponse(call: Call<MovieResponse>?, response: Response<MovieResponse>?) {


                val responseBody = response?.body()
                var moviesDataval = responseBody?.movies
                //movieData= MutableLiveData<List<movies>>()
                movieData.value = moviesDataval
                Log.i("success", movieData.value.toString())


            }

        })

    }

}