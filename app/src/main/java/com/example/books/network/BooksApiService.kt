package com.example.books.network

import retrofit2.http.GET
import retrofit2.http.Path

interface BooksApiService {
    @GET("q={searchTerms}&key=AIzaSyC3sw11n20eOe19lAiwPpGeDj1HIIJCceU")
    suspend fun getVolumesList(@Path("searchTerms") searchTerms : String) : VolumesList
}