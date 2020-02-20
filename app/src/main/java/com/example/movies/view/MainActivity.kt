package com.example.movies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movies.MovieFragment
import com.example.movies.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .add(R.id.fraglayy,MovieFragment(this))
            .commit()


    }
}

