package com.example.androiddevchallenge.ft.browse.cmp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.entity.Trait
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun TraitsHorizontalGrid(traits: List<Trait>) {
    Column {
        Text(
            text = "Search by trait",
            style = MaterialTheme.typography.h2,
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
                items = traits.chunked(2),
                key = { it.first().ordinal },
                itemContent = { itemScope ->
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        TraitCard(trait = itemScope.first())
                        if (itemScope.size > 1) {
                            Spacer(modifier = Modifier.height(8.dp))
                            TraitCard(trait = itemScope[1])
                        }
                    }
                }
            )
        }

    }
}

@Preview
@Composable
fun TraitsHorizontalGridPreview() {
    MyTheme {
        TraitsHorizontalGrid(listOf(Trait.CALM, Trait.DEFENDER, Trait.EASY_TRAINING))
    }
}
