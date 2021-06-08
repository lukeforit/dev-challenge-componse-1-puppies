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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.entity.Puppy
import com.example.androiddevchallenge.ft.browse.BrowsePuppies
import com.example.androiddevchallenge.ft.browse.BrowsePuppiesViewModel
import com.example.androiddevchallenge.ft.details.PuppyDetails
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : AppCompatActivity() {

    private val viewModel: BrowsePuppiesViewModel by viewModels()

    @ExperimentalAnimationApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {

            MyTheme {
                ProvideWindowInsets {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "browse"
                    ) {
                        composable("browse") {
                            val data: List<Puppy> by viewModel.puppies.observeAsState(emptyList())
                            BrowsePuppies(data, navController)
                        }
                        composable(
                            route = "details/{id}",
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
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        Text(text = "Ready... Set... GO!")
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
