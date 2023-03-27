package com.example.books

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.books.ui.BooksApp
import com.example.books.ui.BooksViewModel
import com.example.books.ui.theme.BooksTheme

//const val apiKey = "AIzaSyC3sw11n20eOe19lAiwPpGeDj1HIIJCceU"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BooksTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val booksViewModel : BooksViewModel = viewModel(
                        factory = BooksViewModel.Factory
                    )
                    BooksApp(
                        booksViewModel = booksViewModel
                    )
                }
            }
        }
    }
}