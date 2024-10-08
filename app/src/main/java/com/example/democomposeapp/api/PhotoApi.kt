package com.example.democomposeapp.api
import com.example.democomposeapp.models.TestModel
import retrofit2.Response
import retrofit2.http.GET

interface PhotoApi {
    @GET("users")
    suspend fun testResponse(): Response<List<TestModel>>
}

