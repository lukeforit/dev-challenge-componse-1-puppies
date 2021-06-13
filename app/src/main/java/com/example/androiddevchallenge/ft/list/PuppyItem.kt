package com.example.androiddevchallenge.ft.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.data.entity.Puppy

@Composable
fun PuppyItem(puppy: Puppy, navController: NavController) {
    Row(
        modifier = Modifier
            .clickable {
                navController.navigate("details/${puppy.id}")
            }
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