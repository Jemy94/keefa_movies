package com.jemykeefa.keefamovies.data.model.common

class Resource<out T> constructor(
    val state: ResourceState,
    val data: T? = null,
    val message: String? = null
)