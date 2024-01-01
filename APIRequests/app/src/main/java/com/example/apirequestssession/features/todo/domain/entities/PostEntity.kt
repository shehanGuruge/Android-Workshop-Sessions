package com.example.apirequestssession.features.todo.domain.entities

open class PostEntity (
    open val userId: Int,
    open val id: Int,
    open val title: String,
    open val body: String)