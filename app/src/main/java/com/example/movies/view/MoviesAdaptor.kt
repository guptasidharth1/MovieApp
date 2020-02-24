package com.example.movies.view

import android.R.id
import android.app.FragmentTransaction
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.movies.R
import com.example.movies.model.movies
import kotlinx.android.synthetic.main.item_movie.view.*


class MoviesAdapter(val fragmentManager: FragmentManager,
    private var movies: MutableList<movies>,
    private var context: Context
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }
    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])

    }


    fun updateMovies(movies: List<movies>) {
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val movie_poster = itemView.findViewById<ImageView>(R.id.item_movie_poster)
        private val movie_budget = itemView.movie_title
        private val movie_releasedate = itemView.release_date
        val but = itemView.findViewById<Button>(R.id.button)
        fun bind(movie: movies) {


            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w342${movie.backdrop_path}")
                .transform(CenterCrop())
                .into(movie_poster)

            movie_budget.setText(movie.original_title)
            movie_releasedate.setText(movie.release_date)
            but.setOnClickListener {

                val args = Bundle()
                args.putString("movie_poster", "https://image.tmdb.org/t/p/w342${movie.backdrop_path}")
                args.putString("desc", movie.overview)
                val fr = MovieDetailFragment()
                fr.arguments=args
                fragmentManager.beginTransaction()
                    .add(R.id.fraglayy,fr).addToBackStack("MovieDetailFragment").commit()

            }
        }

    }
}
