package com.example.androiddevchallenge.ft.search.cmp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        Card(
            shape = MaterialTheme.shapes.medium,
            backgroundColor = MaterialTheme.colors.surface
                .compositeOver(MaterialTheme.colors.background),
            modifier = Modifier
                .fillMaxSize()
                .clickable {}
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
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
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 8.dp)
                ) {
                    Text(
                        text = puppy.name,
                        color = MaterialTheme.colors.onSurface,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                    )
                    Divider(
                        color = MaterialTheme.colors.onSurface,
                        thickness = 1.dp,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = puppy.desc,
                        color = MaterialTheme.colors.onSurface,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                    )

                }

            }
//            Icon(
//                painter = painterResource(id = R.drawable.ic_pawprint_outline),
//                contentDescription = "",
//                modifier = Modifier
//                    .size(4.dp)
//                    .background(color = MaterialTheme.colors.secondary)
//                    .padding(8.dp),
//                tint = MaterialTheme.colors.onSecondary
//            )

        }

    }
}

@Preview
@Composable
fun PuppyItemPreview() {
    MyTheme {
        PuppyItem(puppy = Puppy(0, "Test", "")) {}
    }
}