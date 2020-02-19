package com.example.movies


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.model.movies
import com.example.movies.view.MainActivity
import com.example.movies.view.MoviesAdapter
import com.example.movies.view.MoviesRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fraglay.*


class MovieFragment: Fragment() {



    private lateinit var popularMoviesAdapter: MoviesAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater?.inflate(R.layout.fraglay , container, false)




    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mov()
    }

     fun  mov(){



        val popularMovies: RecyclerView = popular_movies

        popularMovies.layoutManager = LinearLayoutManager(
                MainActivity(),
                LinearLayoutManager.VERTICAL,
                false

        )
         fragmentManager?.let {
             popularMoviesAdapter = MoviesAdapter(it,listOf(), MainActivity())
             popularMovies.adapter = popularMoviesAdapter

         }


        MoviesRepository.getPopularMovies(
                onSuccess = ::onPopularMoviesFetched,
                onError = ::onError
        )

    }

    private fun onPopularMoviesFetched(movies: List<movies>) {
        popularMoviesAdapter.updateMovies(movies)
    }

    private fun onError() {
        Toast.makeText(MainActivity(),"Please check your internet connection and try again later", Toast.LENGTH_SHORT).show()
    }




}