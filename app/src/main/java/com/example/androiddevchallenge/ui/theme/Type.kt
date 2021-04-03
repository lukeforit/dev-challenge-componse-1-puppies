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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

val typography = Typography(
    h1 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 28.sp,
        letterSpacing = 1.15.em,
        fontWeight = FontWeight.Light,
    ),
    h2 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 15.sp,
        letterSpacing = 1.15.em,
        fontWeight = FontWeight.Normal,
    ),
    h3 = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 14.sp,
        letterSpacing = 0.em,
        fontWeight = FontWeight.Bold,
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 14.sp,
        letterSpacing = 0.em,
        fontWeight = FontWeight.Normal,
    ),
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 14.sp,
        letterSpacing = 1.15.em,
        fontWeight = FontWeight.SemiBold,
    ),
    caption = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 12.sp,
        letterSpacing = 1.15.em,
        fontWeight = FontWeight.Normal,
    )
)
