package com.example.androiddevchallenge.ft.search.cmp

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.entity.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun PuppiesList(
    puppies: List<Puppy>,
    openPuppyDetails: (Int) -> Unit,
    contentPadding: PaddingValues,
) {
    val listState = rememberLazyListState()
    LazyColumn(
        state = listState,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = contentPadding,
    ) {
        items(items = puppies) { puppy ->
            PuppyItem(puppy, openPuppyDetails)
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Preview
@Composable
fun PuppiesListPreview() {
    MyTheme {
        PuppiesList(
            puppies = listOf(
                Puppy(0, "Test1", ""),
                Puppy(1, "Test2", ""),
                Puppy(2, "A Test3", "")
            ),
            openPuppyDetails = { /*TODO*/ },
            contentPadding = PaddingValues()
        )
    }
}
