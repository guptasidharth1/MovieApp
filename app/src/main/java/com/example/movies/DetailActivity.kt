package com.example.movies

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.view.*
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val data = intent.extras?.getString("poster_path")
        val over =intent.extras?.getString("desc")
        val poster: ImageView=findViewById(R.id.poster_path)
        val description: TextView = findViewById(R.id.desc)
        Glide.with(this)
            .load(data)
            .into(poster)
        description.setText(over)


    }
}