package com.example.movies


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.model.movies
import com.example.movies.view.MainActivity
import com.example.movies.view.MoviesAdapter
import kotlinx.android.synthetic.main.fraglay.*
import com.example.movies.MovieFragment as MovieFragment


class MovieFragment(context: Context) : Fragment() {

    private lateinit var popularMoviesAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater?.inflate(R.layout.fraglay, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initmodels()
        initadaptors()
    }

    private lateinit var view: MovieFragmentViewModel
    private fun initmodels() {
        view = ViewModelProviders.of(this, MovieFragmentViewModelFactory())
            .get(MovieFragmentViewModel::class.java)
        observe()
    }

    private fun initadaptors() {
        popular_movies.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
        val list = mutableListOf<movies>()
        popularMoviesAdapter =  MoviesAdapter(fragmentManager!!, list, activity!!)
        popular_movies.adapter = popularMoviesAdapter
    }

    private fun observe() {
        view.movieData.observe(viewLifecycleOwner, Observer<List<movies>> { movies ->
            popularMoviesAdapter.updateMovies(movies)})
    }
}