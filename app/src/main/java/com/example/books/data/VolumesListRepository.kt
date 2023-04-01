package com.example.books.data

import com.example.books.network.BooksApiService
import com.example.books.network.Volume
import com.example.books.network.VolumesList

interface BooksRepository {
    suspend fun getVolumesList(searchTerms: String) : VolumesList
    /*suspend fun getVolume(volumeId : String) : Volume*/
}

class NetworkBooksRepository(
    private val booksApiService: BooksApiService
) : BooksRepository {
    override suspend fun getVolumesList(searchTerms : String): VolumesList {
        return booksApiService.getVolumesList(searchTerms)
    }

   /* override suspend fun getVolume(volumeId: String): Volume {
        return booksApiService.getVolume(volumeId)
    }*/
}