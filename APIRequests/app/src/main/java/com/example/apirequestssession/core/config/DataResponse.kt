package com.example.apirequestssession.core.config

interface DataResponse<out L, out R> {
    data class Success<R>(val data: R): DataResponse<Nothing, R>
    data class Error<L>(val error: L): DataResponse<L, Nothing>
}






















//
//
//sealed class Some< S,  R> {
//    data class Success<S>(val data: S): Some<Nothing, S>()
//    data class Error<R>(val error: R): Some<R, Nothing>()
//}

//sealed class Some< S> {
//    data class Success<S>(val data: S): Some<S>()
//    data class Error<S>(val error: S): Some<S>()
//}
//
//fun main() {
//    val response: Some<Int, Int> = Some.Success(42)
//    val response2: Some<Int, Int> = Some.Error(42)

//}
//

//fun hello() {
//    val response2: Some.Success<String> = Some.Success("gelo")
//    val error: Some.Error<String> = Some.Error("gelo")
//    val response: DataResponse<String, String> = DataResponse.Error("gelo")
//
//    when(response) {
//        is DataResponse.Error -> TODO()
//        is DataResponse.Success -> TODO()
//    }
//}