package com.example.books.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
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
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = BooksScreen.valueOf(
        backStackEntry?.destination?.route ?: BooksScreen.SEARCH.name
        )
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    if (navController.previousBackStackEntry != null) {
                        IconButton(
                            onClick = {navController.navigateUp()}
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = stringResource(id = R.string.back_btn)
                            )
                        }
                    }
                },
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
                    value = booksViewModel.userInput,
                    onValueChange = {input ->
                        booksViewModel.updateUserInput(input)
                    },
                    onSearch = {
                        navController.navigate(route = BooksScreen.RESULTS.name)
                        booksViewModel.getResults()
                    }
                )
            }
            composable(route = BooksScreen.RESULTS.name) {
                ResultsScreen(
                    booksUiState = booksViewModel.booksUiState
                )
            }
        }
    }
}