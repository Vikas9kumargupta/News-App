package com.example.newsapp.repo

import com.example.newsapp.network.ApiProvider
import com.example.newsapp.network.NewsModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class Repo() {
    suspend fun newProvider() : Response<NewsModel> {
        return ApiProvider.provideApi().getNewsFromServer()
    }
}