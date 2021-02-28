package com.example.androiddevchallenge.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Puppy(val id: Long, val name: String, val img: String) : Parcelable