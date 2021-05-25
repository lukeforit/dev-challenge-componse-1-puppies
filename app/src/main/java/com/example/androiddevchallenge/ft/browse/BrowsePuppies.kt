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
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.entity.Puppy
import com.example.androiddevchallenge.data.entity.Trait
import com.example.androiddevchallenge.ft.browse.cmp.TraitsHorizontalGrid

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
        LazyColumn(state = listState) {
            // FIXME - this crashes the app forsome  reasons
            item {
                val textState = remember { mutableStateOf(TextFieldValue()) }
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    value = textState.value,
                    onValueChange = { textState.value = it },
                    label = { Text("Search a puppy") },
                )
            }
            item {
                TraitsHorizontalGrid(traits = Trait.values().toList())
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
    BrowsePuppies(
        listOf(Puppy(0, "test", "test")),
        rememberNavController()
    )
}
