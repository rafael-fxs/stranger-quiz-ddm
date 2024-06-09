package com.example.strangerquiz

import com.example.strangerquiz.models.Option
import com.example.strangerquiz.models.Question

object Constants {
    fun getQuestion() : ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val options = ArrayList<Option>()
        options.add(Option("1", true))
        options.add(Option("2", false))
        options.add(Option("3", false))
        options.add(Option("4", false))

        questionsList.add(Question(1,"What test is this","url1",options))
        questionsList.add(Question(2,"What test is this","url2",options))
        questionsList.add(Question(3,"What test is this","url3",options))
        return questionsList
    }
}