package com.example.androiddevchallenge.ft.search

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.data.entity.Puppy

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun SearchPuppies(puppies: List<Puppy>, openPuppyDetails: (Int) -> Unit) {
    PuppiesList(puppies, openPuppyDetails)
}