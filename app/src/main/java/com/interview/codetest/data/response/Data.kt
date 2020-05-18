package com.interview.codetest.data.response

data class Data<T>(val dataStatus: DataStatus, val data: T? = null, val error: Throwable? = null)

enum class DataStatus {
    LOADING, SUCCESS, ERROR
}