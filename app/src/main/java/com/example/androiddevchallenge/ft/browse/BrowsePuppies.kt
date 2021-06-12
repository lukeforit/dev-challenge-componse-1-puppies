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

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.entity.Breed
import com.example.androiddevchallenge.data.entity.Puppy
import com.example.androiddevchallenge.data.entity.Trait
import com.example.androiddevchallenge.ft.browse.cmp.HighlightsHorizontalList
import com.example.androiddevchallenge.ft.browse.cmp.TraitsHorizontalGrid
import com.example.androiddevchallenge.ui.theme.MyTheme

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun BrowsePuppies(puppies: List<Puppy>, navController: NavController) {
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
            contentPadding = PaddingValues(top = 56.dp),
            // FIXME below available in new version but it's crashing the app
//            contentPadding = rememberInsetsPaddingValues(
//                insets = LocalWindowInsets.current.systemBars,
//                applyTop = true,
//                applyBottom = true,
//            )
        ) {
            // FIXME - this crashes the app forsome  reasons
            item {
                val textState = remember { mutableStateOf(TextFieldValue()) }
                TextField(
                    value = textState.value,
                    onValueChange = { textState.value = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    textStyle = MaterialTheme.typography.body1,
                    label = { Text("Search a puppy") },
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface
                    )
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
                        PuppyItem(puppy, navController)
                    }
                }
        }

        AnimatedVisibility(
            visible = false, // todo  disable button for now
//            visible = listState.firstVisibleItemIndex > 0,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier.align(alignment = Alignment.BottomCenter)
        ) {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentSize(Alignment.Center),
            ) {
                Icon(
                    imageVector = Icons.Rounded.ExpandLess,
                    contentDescription = "Scroll top",
                    tint = MaterialTheme.colors.secondary,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(
                            color = MaterialTheme.colors.primaryVariant,
                            shape = MaterialTheme.shapes.medium
                        )
                )
            }
        }
    }
}

@Composable
fun PuppyItem(puppy: Puppy, navController: NavController) {
    Row(
        modifier = Modifier
            .clickable {
                navController.navigate("details/${puppy.id}")
            }
            .padding(16.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = puppy.name,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.body1
        )
    }
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Preview
@Composable
fun BrowsePuppiesPreview() {
    MyTheme {
        BrowsePuppies(
            listOf(Puppy(0, "test", "test")),
            rememberNavController()
        )
    }
}
