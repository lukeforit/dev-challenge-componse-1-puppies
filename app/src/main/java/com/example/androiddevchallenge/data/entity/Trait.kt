package com.example.androiddevchallenge.data.entity

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AltRoute
import androidx.compose.material.icons.rounded.Bedtime
import androidx.compose.material.icons.rounded.ChildFriendly
import androidx.compose.material.icons.rounded.Circle
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.FlashOn
import androidx.compose.material.icons.rounded.Shield
import androidx.compose.material.icons.rounded.Sports
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.androiddevchallenge.R

enum class Trait(@StringRes val nameId: Int) {

    KIDS_FRIENDLY(R.string.trait_kids_friendly) {
        override val icon: ImageVector get() = Icons.Rounded.ChildFriendly
    },
    FRIENDLY_TO_ALL(R.string.trait_friendly_to_all) {
        override val icon: ImageVector get() = Icons.Rounded.Face
    },
    DEFENDER(R.string.trait_defender) {
        override val icon: ImageVector get() = Icons.Rounded.Shield
    },
    ENERGETIC(R.string.trait_energetic) {
        override val icon: ImageVector get() = Icons.Rounded.FlashOn
    },
    CALM(R.string.trait_calm) {
        override val icon: ImageVector get() = Icons.Rounded.Bedtime
    },
    HAIRLESS(R.string.trait_hairless) {
        override val icon: ImageVector get() = Icons.Rounded.Circle
    },
    INDEPENDENT(R.string.trait_independent) {
        override val icon: ImageVector get() = Icons.Rounded.AltRoute
    },
    EASY_TRAINING(R.string.trait_easy_training) {
        override val icon: ImageVector get() = Icons.Rounded.Sports
    };

    abstract val icon: ImageVector
}