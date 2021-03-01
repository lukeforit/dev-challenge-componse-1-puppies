package com.example.androiddevchallenge.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PuppiesRepository {

    suspend fun getPuppies(): List<Puppy> {
        return withContext(Dispatchers.IO) {
            listOf(
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