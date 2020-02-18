package com.example.movies.model

import com.google.gson.annotations.SerializedName


data class MovieResponse (
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<movies>,
    @SerializedName("total_pages") val pages: Int
)