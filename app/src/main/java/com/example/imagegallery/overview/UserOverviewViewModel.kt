package com.example.imagegallery.overview

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import coil.compose.SubcomposeAsyncImage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserOverviewViewModel @Inject constructor() : ViewModel() {

    private val _imageRange: MutableState<IntRange> = mutableStateOf(1..20)
    val imageRange: MutableState<IntRange> get() = _imageRange

    fun setImageRange(range: IntRange){
        _imageRange.value = range
    }

    @Composable
    fun loadImage(
        id: Int,
    ){
        SubcomposeAsyncImage(
            model = "https://picsum.photos/id/${id}/200",
            contentDescription = null,
            loading = { CircularProgressIndicator() }
        )
    }

}