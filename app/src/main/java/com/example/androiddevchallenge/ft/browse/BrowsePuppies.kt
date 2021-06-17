/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ft.browse

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.entity.Breed
import com.example.androiddevchallenge.data.entity.Trait
import com.example.androiddevchallenge.ft.browse.cmp.HighlightsHorizontalList
import com.example.androiddevchallenge.ft.browse.cmp.TraitsHorizontalGrid
import com.example.androiddevchallenge.ui.cmp.SearchTextField
import com.example.androiddevchallenge.ui.theme.MyTheme

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun BrowsePuppies(openSearch: () -> Unit) {
    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        val listState = rememberLazyListState()
        LazyColumn(
            state = listState,
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(top = 56.dp, bottom = 56.dp),
            // FIXME below available in new version but it's crashing the app
//            contentPadding = rememberInsetsPaddingValues(
//                insets = LocalWindowInsets.current.systemBars,
//                applyTop = true,
//                applyBottom = true,
//            )
        ) {
            item {
                SearchTextField(
                    value = TextFieldValue(),
                    readOnly = true,
                    onValueChange = {},
                    onClick = openSearch,
                    horizontalPadding = 16.dp
                )
            }
            item {
                TraitsHorizontalGrid(traits = Trait.values().toList())
            }
            item {
                HighlightsHorizontalList(
                    title = stringResource(id = R.string.browse_highlight_featured),
                    breeds = Breed.values().toList()
                )
            }
            item {
                HighlightsHorizontalList(
                    title = stringResource(id = R.string.browse_highlight_best_for_apartments),
                    breeds = Breed.values().toList().shuffled()
                )
            }
            item {
                HighlightsHorizontalList(
                    title = stringResource(id = R.string.browse_highlight_quick_to_learn),
                    breeds = Breed.values().toList().shuffled()
                )
            }
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Preview
@Composable
fun BrowsePuppiesPreview() {
    MyTheme {
        BrowsePuppies {}
    }
}
