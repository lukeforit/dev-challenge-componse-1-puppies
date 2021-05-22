package com.example.androiddevchallenge.ft.browse.cmp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.rememberGlidePainter

@Composable
fun Highlight(uri: String, text: String) {
    Row {
        Image(
            painter = rememberGlidePainter(request = uri),
            contentDescription = "",
            modifier = Modifier.size(88.dp)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onBackground
        )
    }
}

@Preview
@Composable
fun HighlightPreview() {
    Highlight("", "Highlight")
}
