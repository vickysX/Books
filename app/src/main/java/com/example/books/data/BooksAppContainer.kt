package com.example.books.data

import com.example.books.network.BooksApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val booksRepository : BooksRepository
}

class BooksAppContainer : AppContainer {
    private val apiKey = "AIzaSyC3sw11n20eOe19lAiwPpGeDj1HIIJCceU"
    private val baseUrl = "https://www.googleapis.com/books/v1/volumes"
    private val json = Json {
        ignoreUnknownKeys = true
    }
    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()
    private val retrofitService : BooksApiService by lazy {
        retrofit.create(BooksApiService::class.java)
    }
    override val booksRepository: BooksRepository by lazy {
        NetworkBooksRepository(retrofitService)
    }

}