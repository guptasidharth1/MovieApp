package com.example.movies

class MovieChatRepository {
    var movieChat = arrayListOf<Pair<Int, String>>()
    fun movieChatDetails() : ArrayList<Pair<Int, String>>{
        movieChat.add(Pair(0,"Hey"))
        movieChat.add(Pair(1,"Hi"))
        movieChat.add(Pair(0,"How are you"))
        movieChat.add(Pair(1,"I am good, what about you?"))
        movieChat.add(Pair(0,"Well, I am great"))
        movieChat.add(Pair(1,"Nice to see that"))
        movieChat.add(Pair(0,"Where are you these days?"))
        movieChat.add(Pair(1,"Well, I have recently joined testbook as a Software Developer Intern"))
        movieChat.add(Pair(0,"Oh great,:)"))
        movieChat.add(Pair(1,"Hey, listen need to go, talk to you later."))
        return movieChat
    }


}