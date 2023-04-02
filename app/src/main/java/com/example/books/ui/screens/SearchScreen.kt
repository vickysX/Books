package com.example.books.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.books.R
import com.example.books.ui.theme.BooksTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    modifier : Modifier = Modifier,
    onSearch : () -> Unit,
    onValueChange : (String) -> Unit,
    value : String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(
                top = 48.dp,
                bottom = 96.dp,
                start = 48.dp,
                end = 48.dp
            )
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.books_stack),
            contentDescription = null,
        )
        TextField(
            value = value,
            onValueChange = {onValueChange(it)},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_bar)
                )
            },
            placeholder = {
                Text(text = stringResource(id = R.string.search_placeholder))
            },
            shape = RoundedCornerShape(28.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {onSearch}
            ),
            modifier = Modifier
                .border(BorderStroke(Dp.Hairline, Color.Transparent))
        )
        Button(
            onClick = onSearch,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(id = R.string.search_btn),
                fontSize = 18.sp
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun SearchScreenPreview() {
    BooksTheme {
        SearchScreen(
            value = "",
            onValueChange = {},
            onSearch = {}
        )
    }
}