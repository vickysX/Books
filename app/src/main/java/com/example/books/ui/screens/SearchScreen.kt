package com.example.books.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import com.example.books.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    modifier: Modifier = Modifier
) {
    Column() {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.books_stack),
            contentDescription = null
        )
        TextField(
            value = "",
            onValueChange = {},

        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        ) {
            Text(
                stringResource(id = R.string.search_btn)
            )
        }
    }
}