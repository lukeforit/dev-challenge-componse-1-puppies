package com.example.androiddevchallenge.ft.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Puppy
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun PuppyDetails(puppy: Puppy) {
    Column {
        GlideImage(
            data = puppy.img,
            contentDescription = "My content description",
            loading = {
                Box(Modifier.matchParentSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            },
        )

        Text(
            text = puppy.name,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(16.dp)
        )

        Button(onClick = { /*TODO*/ }, Modifier.padding(4.dp).align(Alignment.CenterHorizontally)) {
            Text(text = "Take me home!")
        }
    }
}

@Preview
@Composable
fun PuppyDetailsPreview() {
    PuppyDetails(Puppy(0, "test", "test"))
}