package com.example.newsapp.screen

import androidx.core.app.NotificationCompat.MessagingStyle.Message

sealed class Result<T>(val data : T? = null, val message: String? = null){
    class Success<T>(data: T?): Result<T>(data = data)
    class Loading<T> (message: String?): Result<T>()
    class  Error<T>(message: String?): Result<T>(message = message)
}