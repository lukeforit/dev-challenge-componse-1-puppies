package com.example.androiddevchallenge.ft.browse.cmp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.entity.Breed
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HighlightsHorizontalList(title: String, breeds: List<Breed>) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(Modifier.size(8.dp))
        LazyRow(
            modifier = Modifier.fillMaxHeight(),
            state = rememberLazyListState(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = breeds,
                itemContent = { itemScope ->
                    Highlight(uri = itemScope.thumbnailUrl, text = stringResource(itemScope.nameId))
                }
            )
        }
    }
}

@Preview
@Composable
fun HighlightsHorizontalListPreview() {
    MyTheme {
        HighlightsHorizontalList("Breeds", listOf(Breed.AMERICAN_BULLDOG, Breed.BOXER))
    }
}