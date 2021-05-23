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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.data.entity.Puppy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PuppiesRepository {

    suspend fun getPuppies(): List<Puppy> {
        return withContext(Dispatchers.IO) {
            listOf(
                Puppy(0, "T-Rex", "https://images.dog.ceo/breeds/terrier-patterdale/Patterdale.jpg"),
                Puppy(1, "T-Rex", "https://images.dog.ceo/breeds/terrier-patterdale/Patterdale.jpg"),
                Puppy(2, "Curious", "https://images.dog.ceo/breeds/pekinese/n02086079_1451.jpg"),
                Puppy(3, "Destroyer", "https://images.dog.ceo/breeds/terrier-lakeland/n02095570_5800.jpg"),
                Puppy(4, "Stranger", "https://images.dog.ceo/breeds/corgi-cardigan/n02113186_9063.jpg"),
                Puppy(5, "Fluffy", "https://images.dog.ceo/breeds/mountain-bernese/n02107683_7183.jpg"),
                Puppy(6, "Sunshine", "https://images.dog.ceo/breeds/pyrenees/n02111500_5057.jpg"),
                Puppy(7, "Happy", "https://images.dog.ceo/breeds/spaniel-japanese/n02085782_3400.jpg"),
                Puppy(8, "Giant", "https://images.dog.ceo/breeds/mountain-swiss/n02107574_2222.jpg"),
                Puppy(9, "Buddy", "https://images.dog.ceo/breeds/rottweiler/n02106550_13213.jpg"),
            )
        }
    }
}
