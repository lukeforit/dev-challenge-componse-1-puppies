package com.example.androiddevchallenge.ui.cmp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun SearchTextField(
    value: TextFieldValue,
    readOnly: Boolean,
    onValueChange: (TextFieldValue) -> Unit,
    onClick: () -> Unit,
    horizontalPadding: Dp
) {
    TextField(
        value = value,
        enabled = !readOnly,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .composed {
                if (readOnly) {
                    clickable(onClick = onClick)
                } else {
                    this
                }
            }
            .padding(horizontal = horizontalPadding),
        textStyle = MaterialTheme.typography.body1,
        label = { Text(stringResource(id = R.string.cmp_search_text_field_label)) },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
                .compositeOver(MaterialTheme.colors.background)
        )
    )

}

@Preview
@Composable
fun SearchTextFieldPreview() {
    MyTheme {
        SearchTextField(
            value = TextFieldValue(),
            readOnly = false,
            onValueChange = {},
            onClick = {},
            horizontalPadding = 16.dp
        )
    }
}