package com.example.androiddevchallenge.ft.browse

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.Puppy

@Composable
fun BrowsePuppies(puppies: List<Puppy>, navController: NavController){
    LazyColumn(
        state = rememberLazyListState()
    ) {
        items(puppies, Puppy::id) { puppy ->
            PuppyItem(puppy, navController)
        }
    }
}

@Composable
fun PuppyItem(puppy: Puppy, navController: NavController) {
    Row(
        modifier = Modifier
            .padding(5.dp)
            .clickable {
                navController.navigate("details/${puppy.id}")
            },
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
fun BrowsePuppiesPreview(){
    BrowsePuppies(
        listOf(Puppy(0, "test", "test")),
        rememberNavController()
    )
}