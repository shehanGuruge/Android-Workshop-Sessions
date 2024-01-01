package com.example.androidsession3.core.config


abstract class UseCase<Type, Params> {
    abstract suspend operator fun invoke(params: Params?): DataResponse<Failure, Type?>
}