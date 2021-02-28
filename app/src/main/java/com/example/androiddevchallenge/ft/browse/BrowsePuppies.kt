package com.example.androiddevchallenge.ft.browse

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.data.Puppy

@Composable
fun BrowsePuppies(puppies: List<Puppy>){
    Column(
        Modifier.verticalScroll(rememberScrollState())
    ) {
        puppies.forEach {
            Text(text = it.name)
        }
    }
}

@Preview
@Composable
fun BrowsePuppiesPreview(){
    BrowsePuppies(listOf(Puppy("test", "test")))
}