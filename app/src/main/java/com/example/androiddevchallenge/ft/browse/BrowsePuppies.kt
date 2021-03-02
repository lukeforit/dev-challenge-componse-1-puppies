package com.example.androiddevchallenge.ft.browse

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.Puppy

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun BrowsePuppies(puppies: List<Puppy>, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        val listState = rememberLazyListState()
        LazyColumn(state = listState) {
            puppies
                .groupBy { it.name[0] }
                .forEach { (character, puppiesGroup) ->
                    stickyHeader {
                        Surface(color = MaterialTheme.colors.secondary) {
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
            visible = listState.firstVisibleItemIndex > 0,
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
                            color = MaterialTheme.colors.primary,
                            shape = MaterialTheme.shapes.large
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