package com.example.androiddevchallenge.nav

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.androiddevchallenge.data.entity.Puppy
import com.example.androiddevchallenge.ft.browse.BrowsePuppies
import com.example.androiddevchallenge.ft.browse.BrowsePuppiesViewModel
import com.example.androiddevchallenge.ft.details.PuppyDetails

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun PuppiesNavigation(
    navController: NavHostController,
    viewModel: BrowsePuppiesViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Destination.Browse.route
    ) {
        composable(Destination.Browse.route) {
            val data: List<Puppy> by viewModel.puppies.observeAsState(emptyList())
            BrowsePuppies(data, navController)
        }
        composable(
            route = "${Destination.Browse.route}/{id}",
            // Parcelable arguments are not supported now
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id", 0)!!
            PuppyDetails(viewModel.puppies.value?.get(id)!!) // FIXME - this is horrible
        }
    }

}