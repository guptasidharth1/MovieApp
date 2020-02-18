package com.example.movies.view

import com.example.movies.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "cdd99989813fed4e37718a796236c5f6",
        @Query("page") page: Int
    ): Call<MovieResponse>
}
