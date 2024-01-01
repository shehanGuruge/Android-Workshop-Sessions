package com.example.androidsession3.core.config

interface DataResponse<out L, out R> {
    data class Success<R>(val data: R): DataResponse<Nothing, R>
    data class Error<L>(val error: L): DataResponse<L, Nothing>
}
