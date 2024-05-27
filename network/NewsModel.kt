package com.example.newsapp.network

data class NewsModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)