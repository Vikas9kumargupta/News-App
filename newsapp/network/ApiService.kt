package com.example.newsapp.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    suspend fun getNewsFromServer(
        @Query("country") country : String = "in",
        @Query("sortBy") sortBy : String = "publishedAt",
        @Query("apiKey") apiKey : String = "b394cda1f65c4ea4b0a36b15370e6b22"
    ): Response<NewsModel>
}

//https://newsapi.org/v2/top-headlines?country=in&sortBy=publishedAt&apiKey=b394cda1f65c4ea4b0a36b15370e6b22