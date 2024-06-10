package com.example.strangerquiz

import com.example.strangerquiz.model.Option
import com.example.strangerquiz.model.Question

object Constants {
    fun getQuestion() : ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val options = ArrayList<Option>()
        options.add(Option("1", true))
        options.add(Option("2", false))
        options.add(Option("3", false))
        options.add(Option("4", false))

        questionsList.add(Question(1,"What test is this1","url1",options))
        questionsList.add(Question(2,"What test is this2","url2",options))
        questionsList.add(Question(3,"What test is this3","url3",options))
        return questionsList
    }
}