package com.example.books.ui

import com.example.books.network.Volume
import com.example.books.network.VolumesList

sealed interface BooksUiState {
    data class Success(
        val results: VolumesList,
        val volumes: List<Volume>
    ) : BooksUiState
    object Loading : BooksUiState
    object Error : BooksUiState
}