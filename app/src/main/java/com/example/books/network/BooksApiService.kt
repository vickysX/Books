package com.example.books.network

import retrofit2.http.GET
import retrofit2.http.Query

const val apiKey = "AIzaSyC3sw11n20eOe19lAiwPpGeDj1HIIJCceU"
interface BooksApiService {

    @GET("volumes")
    suspend fun getVolumesList(
        @Query("q") searchTerms : String,
        @Query("key") key : String = apiKey
    ) : VolumesList
    /*@GET("volumes?q={searchTerms}&key=AIzaSyC3sw11n20eOe19lAiwPpGeDj1HIIJCceU")
    suspend fun getVolumesList(@Query("searchTerms") searchTerms : String) : VolumesList*/

    /*@GET("/{volumeId}?key=AIzaSyC3sw11n20eOe19lAiwPpGeDj1HIIJCceU")
    suspend fun getVolume(@Path("volumeId") volumeId : String) : Volume*/
}