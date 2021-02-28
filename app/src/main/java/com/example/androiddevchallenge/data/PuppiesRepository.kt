package com.example.androiddevchallenge.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PuppiesRepository {

    suspend fun getPuppies(): List<Puppy> {
        return withContext(Dispatchers.IO) {
            emptyList()
        }
    }
}