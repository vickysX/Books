package com.example.books.data

import com.example.books.network.BooksApiService
import com.example.books.network.VolumesList

interface VolumesListRepository {
    suspend fun getVolumesList(searchTerms: String) : VolumesList
}

class NetworkVolumesListRepository(
    private val booksApiService: BooksApiService
) : VolumesListRepository {
    override suspend fun getVolumesList(searchTerms : String): VolumesList {
        return booksApiService.getVolumesList(searchTerms)
    }
}