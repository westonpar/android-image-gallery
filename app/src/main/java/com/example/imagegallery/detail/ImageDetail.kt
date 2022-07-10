package com.example.imagegallery.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ImageDetail(
    imageId: Int,
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier,
) {

    val viewModel: ImageDetailViewModel = hiltViewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Image #${imageId}",
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { navigator.popBackStack() },
                        content = { Icon(imageVector = Icons.Filled.ArrowBack, null) }
                    )
                }
            )
        },
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            ) {
            viewModel.loadImage(id = imageId)
            if (viewModel.state.value) {
                Text(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    fontSize = 24.sp,
                    text = "Details about the above image:\n blah blah blaaahh blahh blah blahh blah"
                )
            }
        }
    }
}