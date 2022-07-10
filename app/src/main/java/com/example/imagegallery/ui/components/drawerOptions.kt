package com.example.imagegallery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp

@Composable
fun drawerOptions(
    modifier: Modifier = Modifier,
    onSelectRange: (IntRange) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {

        TopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.background),
            title = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Select an Image Set",
                )
            }
        )

        ClickableText(
            text = AnnotatedString("Images 0 - 19"),
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(16.dp),
            onClick = { onSelectRange(0..19) }
        )
        ClickableText(
            text = AnnotatedString("Images 20 - 99"),
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(16.dp),
            onClick = { onSelectRange(20..99) }
        )
        ClickableText(
            text = AnnotatedString("Images 100 - 109"),
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(16.dp),
            onClick = { onSelectRange(100..109) }
        )
        ClickableText(
            text = AnnotatedString("Images 110 - 150"),
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(16.dp),
            onClick = { onSelectRange(110..150) }
        )
    }
}