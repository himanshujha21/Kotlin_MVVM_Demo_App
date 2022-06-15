package com.example.kotlinmvvm.repository

import com.example.kotlinmvvm.api.RetrofitService

class MainRepository(val retrofitService: RetrofitService) {
    suspend fun getAllMovies() = retrofitService.getAllMovies()

}