package com.example.imagegallery.detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import coil.compose.SubcomposeAsyncImage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ImageDetailViewModel @Inject constructor() : ViewModel() {

    private val _state: MutableState<Boolean> = mutableStateOf(false)
    val state: MutableState<Boolean> get() = _state

    @Composable
    fun loadImage(
        id: Int,
    ) {
        SubcomposeAsyncImage(
            model = "https://picsum.photos/id/${id}/1000",
            contentDescription = null,
            onSuccess = { _state.value = true },
            loading = {
                CircularProgressIndicator(
                    strokeWidth = 32.dp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        )
    }

}