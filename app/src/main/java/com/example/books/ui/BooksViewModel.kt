package com.example.books.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.books.BooksApplication
import com.example.books.data.BooksRepository
import com.example.books.network.Volume
import com.example.books.network.VolumeInfo
import com.example.books.network.VolumesList
import kotlinx.coroutines.launch
import java.io.IOException

class BooksViewModel(
    private val booksRepository: BooksRepository
) : ViewModel() {

    var userInput : String by mutableStateOf("")
        private set

    var booksUiState : BooksUiState by mutableStateOf(BooksUiState.Loading)
        private set

    fun updateUserInput(input : String) {
        userInput = input
    }

    fun getResults() {
        viewModelScope.launch {
            booksUiState = try {
                BooksUiState.Success(
                    booksRepository.getVolumesList(userInput),
                    getVolumes()
                )
            } catch (_ : IOException) {
                BooksUiState.Error
            }
        }
    }

    private suspend fun getVolumes() : List<Volume> {
        val volumesInfo : MutableList<Volume> = mutableListOf()
        booksRepository.getVolumesList(userInput).items.forEach {
            volumesInfo.add(it)
        }
        return volumesInfo
    }

    companion object {
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BooksApplication)
                val container = application.container
                BooksViewModel(container.booksRepository)
            }
        }
    }
}