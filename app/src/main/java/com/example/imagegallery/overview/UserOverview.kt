package com.example.imagegallery.overview

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.imagegallery.destinations.ImageDetailDestination
import com.example.imagegallery.ui.components.drawerOptions
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch


@Destination(start = true)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UserOverview(
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier,
) {

    val viewModel: UserOverviewViewModel = hiltViewModel()

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Image Gallery",
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            coroutineScope.launch {
                                scaffoldState.drawerState.open()
                            }
                        },
                        content = {
                            Icon(imageVector = Icons.Filled.Menu, null)
                        }
                    )
                }
            )
        },
        drawerContent = {
            drawerOptions(
                onSelectRange = { imageRange ->
                    viewModel.setImageRange(imageRange)
                }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
        ) {
            items(viewModel.imageRange.value.toList()) { id ->
                Card(
                    elevation = 8.dp,
                    modifier = modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    onClick = {
                        navigator.navigate(ImageDetailDestination(id)) }
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        viewModel.loadImage(
                            id = id
                        )
                        Text(
                            text = "Image #${id}",
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.SemiBold,
                            modifier = modifier
                                .padding(4.dp)
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

