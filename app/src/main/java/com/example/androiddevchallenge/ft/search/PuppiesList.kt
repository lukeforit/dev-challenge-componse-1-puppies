package com.example.androiddevchallenge.ft.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.entity.Breed
import com.example.androiddevchallenge.data.entity.Puppy
import com.example.androiddevchallenge.data.entity.Trait
import com.example.androiddevchallenge.ft.browse.cmp.HighlightsHorizontalList
import com.example.androiddevchallenge.ft.browse.cmp.TraitsHorizontalGrid
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.statusBarsPadding
import kotlin.math.roundToInt

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun PuppiesList(puppies: List<Puppy>, navController: NavController) {
    val searchTextField = 56.dp
    val searchTextFieldPx = with(LocalDensity.current) {
        searchTextField.roundToPx().toFloat()
    } + LocalWindowInsets.current.statusBars.top
    val searchTextFieldOffsetPx = remember { mutableStateOf(0f) }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {

                val delta = available.y
                val newOffset = searchTextFieldOffsetPx.value + delta
                searchTextFieldOffsetPx.value = newOffset.coerceIn(-searchTextFieldPx, 0f)
                return Offset.Zero
            }
        }
    }

    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .fillMaxWidth()
            .fillMaxHeight()
            .nestedScroll(nestedScrollConnection)
            .offset { IntOffset(x = 0, y = searchTextFieldOffsetPx.value.roundToInt()) }
    ) {
        val listState = rememberLazyListState()
        LazyColumn(
            state = listState,
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(top = 56.dp),
        ) {
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

        val textState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .height(searchTextField)
                .offset { IntOffset(x = 0, y = searchTextFieldOffsetPx.value.roundToInt()) }
                .padding(horizontal = 16.dp),
            textStyle = MaterialTheme.typography.body1,
            label = { Text("Search a puppy") },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface
                    .compositeOver(MaterialTheme.colors.background)
            )
        )
    }

}