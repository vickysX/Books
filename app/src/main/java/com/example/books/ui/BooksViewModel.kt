package com.example.books.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.books.BooksApplication
import com.example.books.data.VolumesListRepository

class BooksViewModel(
    private val volumesListRepository: VolumesListRepository
) : ViewModel() {

    var userInput : String by mutableStateOf("")
        private set

    companion object {
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BooksApplication)
                val container = application.container
                BooksViewModel(container.volumesListRepository)
            }
        }
    }
}