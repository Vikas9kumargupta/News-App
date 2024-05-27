package com.example.newsapp.screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.network.NewsModel
import com.example.newsapp.repo.Repo
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch

class NewsViewModel() : ViewModel() {
    var res = mutableStateOf<NewsModel?>(null)
    init{
        viewModelScope.launch {
           res.value =  getNews(Repo())
        }
    }
    private suspend fun getNews(repo: Repo): NewsModel? {
        return repo.newProvider().body()
    }
}