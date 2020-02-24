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

private lateinit var okHttpClient: OkHttpClient


private val retrofit = Retrofit.Builder()
    .baseUrl("https://api.themoviedb.org/3/")
    .addConverterFactory(GsonConverterFactory.create())
//   .client(okHttpClient)
    .build()



interface ApiInterface {




    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = "cdd99989813fed4e37718a796236c5f6",
        @Query("page") page: Int
    ): MovieResponse


//
//    @GET("movie/popular")
//    fun getPopularMovies(
//        @Query("api_key") apiKey: String = "cdd99989813fed4e37718a796236c5f6",
//        @Query("page") page: Int
//    ): Call<MovieResponse>

}


object MovieApi{

    val retrofitservice : ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }
//    private lateinit var okHttpClient: OkHttpClient
//
//   // if (!MovieApi::okHttpClient.isInitialized) {
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.level = HttpLoggingInterceptor.Level.BODY
//        okHttpClient = OkHttpClient.Builder()
//            .addInterceptor(HeaderInterceptor())
//            .addInterceptor(interceptor)
//            .addNetworkInterceptor(StethoInterceptor())
//            .build()
//
//
//
//   // }

}
