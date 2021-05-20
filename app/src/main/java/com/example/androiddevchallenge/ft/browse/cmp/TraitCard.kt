package com.example.androiddevchallenge.ft.browse.cmp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChildFriendly
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun TraitCard() {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.size(width = 192.dp, height = 56.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = Icons.Rounded.ChildFriendly,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .background(color = MaterialTheme.colors.background)
                    .aspectRatio(1f)
                    .padding(8.dp)
            )
            Text(
                text = "Dog's trait",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(horizontal = 16.dp),

            )
        }
    }
}

@Preview
@Composable
fun TraitCardPreview() {
    MyTheme {
        TraitCard()
    }
}