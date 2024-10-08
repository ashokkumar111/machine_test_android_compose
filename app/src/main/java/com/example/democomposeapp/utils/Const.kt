package com.example.democomposeapp.utils

import com.google.gson.Gson

object Const {
    const val BaseUrl = "https://jsonplaceholder.typicode.com/"

    //Json String To Object
    fun <A> String.fromJson(type: Class<A>): A {
        return Gson().fromJson(this, type)
    }

    //Object to Json String
    fun <A> A.toJson(): String? {
        return Gson().toJson(this)
    }
}