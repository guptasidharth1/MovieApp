package com.example.movies.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R

class MovieChatAdaptor(
    private var chatMovieData : ArrayList<Pair<Int, String>>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    fun updateChatData(chat : ArrayList<Pair<Int, String>>){
        this.chatMovieData.addAll(chat)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = chatMovieData.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            0->{
               val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.mychatlayout, parent, false)
                    return MyChatViewHolder(view)
            }
            else->{

                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.clientchatlayout, parent, false)
                return YourChatViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = holder.itemViewType
        when (viewType) {
            0 -> {
                onBindMyChat(holder, chatMovieData.get(position).second)

            }
            else -> {
                onBindClientChat(holder, chatMovieData.get(position).second)
            }
        }
        }


    override fun getItemViewType(position: Int): Int {
        if (chatMovieData.get(position).first == 0)
            return 0
        else
            return 1
    }

    class MyChatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val mychatmap : TextView = itemView.findViewById(R.id.my_chat_textview)
    }

    class YourChatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val yourchatmap : TextView = itemView.findViewById(R.id.client_chat_textview)
    }

    private fun onBindMyChat(holder: RecyclerView.ViewHolder, string: String) {
        (holder as MyChatViewHolder).mychatmap.setText(string)
    }

    private fun onBindClientChat(holder: RecyclerView.ViewHolder, string: String) {
        (holder as YourChatViewHolder).yourchatmap.setText(string)
    }

}