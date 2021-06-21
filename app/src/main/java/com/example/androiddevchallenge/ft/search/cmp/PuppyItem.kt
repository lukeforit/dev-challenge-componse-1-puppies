package com.example.androiddevchallenge.ft.search.cmp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.entity.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.google.accompanist.glide.rememberGlidePainter

@Composable
fun PuppyItem(puppy: Puppy, openPuppyDetails: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .clickable { openPuppyDetails(puppy.id) }
            .padding(horizontal = 16.dp)
            .height(88.dp)
            .fillMaxWidth(),
    ) {
        Image(
            painter = rememberGlidePainter(
                request = puppy.img,
                previewPlaceholder = R.drawable.ic_pawprint_outline
            ),
            contentScale = ContentScale.Crop,
            contentDescription = "",
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1.0f)
                .clip(MaterialTheme.shapes.medium)
        )

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