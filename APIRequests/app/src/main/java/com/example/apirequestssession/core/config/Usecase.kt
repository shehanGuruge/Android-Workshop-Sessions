package com.example.apirequestssession.core.config

abstract class Usecase<Type, Params> {
    abstract suspend operator fun invoke(params: Params?): DataResponse<Failure, Type?>
}