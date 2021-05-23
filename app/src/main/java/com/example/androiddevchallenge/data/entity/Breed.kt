package com.example.androiddevchallenge.data.entity

import androidx.annotation.StringRes
import com.example.androiddevchallenge.R

private const val BASE_URL = "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/"

enum class Breed(
    @StringRes val nameId: Int,
    val thumbnailUrl: String
) {
    AMERICAN_BULLDOG(
        R.string.breed_american_bulldog,
        "${BASE_URL}2019/12/31141713/American-Bulldog-head.jpg"
    ),
    BASENJI(
        R.string.breed_basenji,
        "${BASE_URL}2017/11/14150209/Basenji-puppy-laying-down-on-a-white-background.jpg"
    ),
    BEAGLE(
        R.string.breed_beagle,
        "${BASE_URL}2017/11/02141506/Beagle-Puppy.jpg"
    ),
    BOERBOEL(
        R.string.breed_boerboel,
        "${BASE_URL}2017/11/29195506/Boerboel-puppy.jpg"
    ),
    BOXER(
        R.string.breed_boxer,
        "${BASE_URL}2017/11/04135344/Boxer-puppy-laying-down.jpg"
    ),
    CHIHUAHUA(
        R.string.breed_chihuahua,
        "${BASE_URL}2017/11/27134552/Chihuahua-laying-down-with-her-puppies.jpg"
    ),
    DALMATIAN(
        R.string.breed_dalmatian,
        "${BASE_URL}2017/11/04143301/Dalmatian-puppies-sitting-in-a-row.jpg"
    ),
}