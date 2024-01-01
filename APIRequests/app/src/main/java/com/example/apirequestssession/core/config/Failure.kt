package com.example.apirequestssession.core.config

abstract class Failure (open val code: String?, open val message: String?)

class NetworkFailure(override val code: String?, override val message: String?): Failure(code, message)

class AppFailure(override val code: String?, override val message: String?): Failure(code, message)
