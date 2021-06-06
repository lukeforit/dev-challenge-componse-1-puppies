package com.example.androiddevchallenge.data.entity

import androidx.annotation.StringRes
import com.example.androiddevchallenge.R

enum class Trait(@StringRes val nameId: Int) {
    KIDS_FRIENDLY(R.string.trait_kids_friendly),
    FRIENDLY_TO_ALL(R.string.trait_friendly_to_all),
    DEFENDER(R.string.trait_defender),
    ENERGETIC(R.string.trait_energetic),
    CALM(R.string.trait_calm),
    HAIRLESS(R.string.trait_hairless),
    INDEPENDENT(R.string.trait_independent),
    EASY_TRAINING(R.string.trait_easy_training),
}