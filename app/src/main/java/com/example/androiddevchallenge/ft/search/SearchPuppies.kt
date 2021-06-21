package com.example.androiddevchallenge.ft.search

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.entity.Puppy
import com.example.androiddevchallenge.ui.cmp.SearchTextField
import kotlin.math.roundToInt

private object SearchPuppiesBounds {
    val searchTextFieldHeight: Dp get() = TextFieldDefaults.MinHeight
    val topPadding: Dp get() = TextFieldDefaults.MinHeight
    val verticalSpaceBy: Dp get() = 16.dp
    val listTopPadding: Dp get() = topPadding + searchTextFieldHeight + verticalSpaceBy
    val listBottomPadding: Dp get() = TextFieldDefaults.MinHeight
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun SearchPuppies(puppies: List<Puppy>, openPuppyDetails: (Int) -> Unit) {
    val topOffsetPx = with(LocalDensity.current) {
        SearchPuppiesBounds.listTopPadding.roundToPx().toFloat()
    }
    val searchTextFieldOffsetPx = remember { mutableStateOf(0f) }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val newOffset = searchTextFieldOffsetPx.value + available.y * 0.64f
                searchTextFieldOffsetPx.value = newOffset.coerceIn(-topOffsetPx, 0f)
                return Offset.Zero
            }
        }
    }

    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .fillMaxWidth()
            .fillMaxHeight()
            .nestedScroll(nestedScrollConnection)

    ) {
        PuppiesList(
            puppies = puppies,
            openPuppyDetails = openPuppyDetails,
            contentPadding = PaddingValues(
                top = SearchPuppiesBounds.listTopPadding,
                bottom = SearchPuppiesBounds.listBottomPadding
            )
        )

        val textState = remember { mutableStateOf(TextFieldValue()) }
        SearchTextField(
            value = textState.value,
            readOnly = false,
            onValueChange = { textState.value = it },
            onClick = { },
            horizontalPadding = 16.dp,
            modifier = Modifier
                .padding(top = SearchPuppiesBounds.topPadding)
                .offset { IntOffset(x = 0, y = searchTextFieldOffsetPx.value.roundToInt()) }
        )
    }
}
