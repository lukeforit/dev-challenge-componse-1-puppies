/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ft.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.entity.Puppy
import com.google.accompanist.glide.rememberGlidePainter

@Composable
fun PuppyDetails(puppy: Puppy) {
    Column {
        Image(
            painter = rememberGlidePainter(puppy.img, fadeIn = true),
            contentDescription = "My content description",
//            loading = {
//                Box(Modifier.matchParentSize()) {
//                    CircularProgressIndicator(Modifier.align(Alignment.Center))
//                }
//            },
        )

        Text(
            text = puppy.name,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(16.dp)
        )

        Button(onClick = { /*TODO*/ },
            Modifier
                .padding(4.dp)
                .align(Alignment.CenterHorizontally)) {
            Text(text = "Take me home!")
        }
    }
}

@Preview
@Composable
fun PuppyDetailsPreview() {
    PuppyDetails(Puppy(0, "test", "test"))
}
