package com.example.books.network

import retrofit2.http.GET
import retrofit2.http.Path

interface BooksApiService {
    @GET("q={searchTerms}")
    suspend fun getVolumesList(@Path("searchTerms") searchTerms : String) : VolumesList
}