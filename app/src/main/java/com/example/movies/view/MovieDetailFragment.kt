package com.example.movies.view

import android.graphics.Insets.add
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import com.bumptech.glide.Glide
import com.example.movies.MovieFragment
import com.example.movies.R
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.view.*


class MovieDetailFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_detail, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val image = arguments?.getString("movie_poster")
        val movie_descriotion = arguments?.getString("desc")
        val next_fragment = chat_button

        view.desc.setText(movie_descriotion)
        Glide.with(this)
            .load(image)
            .into(poster_path_movie)
        back_button.setOnClickListener{
            parentFragmentManager.popBackStack()
        }

        next_fragment.setOnClickListener{
            fragmentManager?.beginTransaction()?.add(R.id.fraglayy,MovieChatFragment()
            )?.addToBackStack("MovieChatFragment")?.commit()
        }
    }
}