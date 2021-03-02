package com.example.androiddevchallenge.ft.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.data.Puppy
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun PuppyDetails(puppy: Puppy) {
    Row() {
        GlideImage(
            data = puppy.img,
            contentDescription = "My content description",
            loading = {
                Box(Modifier.matchParentSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            },
        )
    }
}

@Preview
@Composable
fun PuppyDetailsPreview() {
    PuppyDetails(Puppy(0, "test", "test"))
}