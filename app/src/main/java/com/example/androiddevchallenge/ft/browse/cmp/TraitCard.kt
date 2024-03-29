package com.example.androiddevchallenge.ft.browse.cmp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChildFriendly
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.entity.Trait
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun TraitCard(trait: Trait) {
    Card(
        shape = MaterialTheme.shapes.small,
        backgroundColor = MaterialTheme.colors.surface
            .compositeOver(MaterialTheme.colors.background),
        modifier = Modifier
            .size(width = 192.dp, height = 56.dp)
            .clickable {}
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = trait.icon,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .background(color = MaterialTheme.colors.secondary)
                    .aspectRatio(1f)
                    .padding(8.dp),
                tint = MaterialTheme.colors.onSecondary
            )
            Text(
                text = stringResource(id = trait.nameId),
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(horizontal = 16.dp),
            )
        }
    }
}

@Preview
@Composable
fun TraitCardPreview() {
    MyTheme {
        TraitCard(Trait.CALM)
    }
}