package com.example.books.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.books.R
import com.example.books.network.Volume
import com.example.books.network.VolumeInfo
import com.example.books.network.VolumesList
import com.example.books.ui.BooksUiState
import com.example.books.ui.BooksUiState.*

@Composable
fun ResultsScreen(
    modifier: Modifier = Modifier,
    booksUiState: BooksUiState
) {
    when (booksUiState) {
        is Success -> BooksList(
            results = booksUiState.results,
            volumes = booksUiState.volumes
        )
        is Loading -> LoadingScreen()
        is Error -> ErrorScreen()
    }
}

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {

}

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier
) {

}

@Composable
fun BooksList(
    modifier: Modifier = Modifier,
    results : VolumesList,
    volumes : List<Volume>
) {
    Column() {
        Text(
            text = stringResource(
                R.string.num_results,
                results.items.size
            )
        )
        LazyColumn() {
            items(items = volumes, key = {volume -> volume.volumeId}) {
                BookCard(volume = it.volumeInfo)
            }
        }
    }
}

@Composable
fun BookCard(
    modifier: Modifier = Modifier,
    volume : VolumeInfo
) {
    Card() {
        Row() {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(volume.imageLinks.thumbnail)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(
                        id = R.string.cover_description,
                        volume.title
                )

            )
            Column() {
                val authors = {
                    val firstAuthor = if (volume.authors.isEmpty()) {
                        ""
                    } else {
                        volume.authors[0]
                    }
                    val sb : StringBuilder = StringBuilder(firstAuthor)
                    if (volume.authors.size > 1) {
                        volume.authors.forEach {
                            sb.append(", $it")
                        }
                    }
                    sb.toString()
                }
                Text(
                    text = volume.title
                )
                Text(
                    text = authors()
                )
                Text(
                    text = stringResource(id = R.string.pages, volume.pageCount.toString())
                )
                Text(
                    text = volume.mainCategory
                )
                Text(
                    text = volume.description
                )
            }
        }
    }
}