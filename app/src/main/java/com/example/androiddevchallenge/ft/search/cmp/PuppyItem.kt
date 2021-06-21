package com.example.androiddevchallenge.ft.search.cmp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.entity.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PuppyItem(puppy: Puppy, openPuppyDetails: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .clickable { openPuppyDetails(puppy.id) }
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

@Preview
@Composable
fun PuppyItemPreview() {
    MyTheme {
        PuppyItem(puppy = Puppy(0, "Test", "")) {}
    }
}