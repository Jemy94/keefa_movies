package com.jemykeefa.keefamovies.data.model.common

sealed class ResourceState {

    object LOADING : ResourceState()
    object SUCCESS : ResourceState()
    object ERROR : ResourceState()
}