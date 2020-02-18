package com.example.movies.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.movies.DetailActivity
import com.example.movies.R
import com.example.movies.model.movies
import kotlinx.android.synthetic.main.item_movie.view.*
import java.util.concurrent.CopyOnWriteArrayList


class MoviesAdapter(
    private var movies: List<movies>,
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
        this.movies = movies
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
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("poster_path", "https://image.tmdb.org/t/p/w342${movie.backdrop_path}")
                intent.putExtra("desc",movie.overview)
                context.startActivity(intent)

            }
        }

    }
}
