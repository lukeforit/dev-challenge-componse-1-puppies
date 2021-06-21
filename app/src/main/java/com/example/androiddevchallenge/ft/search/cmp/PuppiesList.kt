package com.example.androiddevchallenge.ft.search.cmp

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        verticalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = contentPadding,
    ) {
        puppies
            .sortedBy(Puppy::name)
            .groupBy { it.name[0] }
            .forEach { (character, puppiesGroup) ->
                stickyHeader {
                    Surface(color = MaterialTheme.colors.surface) {
                        Text(
                            text = character.toString(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            style = MaterialTheme.typography.subtitle1
                        )
                    }
                }
                items(items = puppiesGroup, key = Puppy::id) { puppy ->
                    PuppyItem(puppy, openPuppyDetails)
                }
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
