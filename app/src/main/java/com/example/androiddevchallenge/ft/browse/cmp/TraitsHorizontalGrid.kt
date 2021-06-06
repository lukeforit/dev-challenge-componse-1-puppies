package com.example.androiddevchallenge.ft.browse.cmp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.entity.Trait

@Composable
fun TraitsHorizontalGrid(traits: List<Trait>) {
    LazyRow(
        modifier = Modifier.fillMaxHeight(),
        state = rememberLazyListState(),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(
            items = traits.zipWithNext(),
            itemContent = { itemScope ->
                Column(
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    TraitCard(trait = itemScope.first)
                    Spacer(modifier = Modifier.height(8.dp))
                    TraitCard(trait = itemScope.second)
                }
            }
        )
    }
}

@Preview
@Composable
fun TraitsHorizontalGridPreview() {
    TraitsHorizontalGrid(listOf(Trait.CALM, Trait.DEFENDER))
}
