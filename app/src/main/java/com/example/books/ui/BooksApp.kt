package com.example.books.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.books.R
import com.example.books.ui.screens.ResultsScreen
import com.example.books.ui.screens.SearchScreen

enum class BooksScreen {
    SEARCH, RESULTS
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BooksApp(
    modifier: Modifier = Modifier,
    booksViewModel: BooksViewModel
) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                // TODO: Implement back button with backwards navigation
                title = {
                    Text(text = stringResource(R.string.app_name))
                }
            )
        }
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = BooksScreen.SEARCH.name
        ) {
            composable(route = BooksScreen.SEARCH.name) {
                SearchScreen(
                    value = "",
                    onValueChange = {}
                )
            }
            composable(route = BooksScreen.RESULTS.name) {
                ResultsScreen()
            }
        }
    }
}