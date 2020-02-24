package com.example.movies.view

import com.example.movies.model.MovieResponse
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val retrofit = Retrofit.Builder()
    .baseUrl("https://api.themoviedb.org/3/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface ApiInterface {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = "cdd99989813fed4e37718a796236c5f6",
        @Query("page") page: Int
    ): MovieResponse

}

object MovieApi{
    val retrofitservice : ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }
}
