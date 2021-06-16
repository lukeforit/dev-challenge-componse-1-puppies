package com.example.androiddevchallenge.nav

sealed class Destination(val route: String) {
    object Browse : Destination("dst_browse")
    object Search : Destination("dst_search")
    object PuppyDetails : Destination("dst_puppy_details")
}