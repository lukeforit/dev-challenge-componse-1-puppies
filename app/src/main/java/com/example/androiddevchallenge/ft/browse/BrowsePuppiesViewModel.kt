package com.example.androiddevchallenge.ft.browse

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.androiddevchallenge.data.Puppy

class BrowsePuppiesViewModel : ViewModel() {

    val puppies: LiveData<List<Puppy>> = liveData {
        emit(emptyList<Puppy>())
    }
}
