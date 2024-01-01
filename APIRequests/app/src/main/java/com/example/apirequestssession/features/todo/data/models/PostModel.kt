package com.example.apirequestssession.features.todo.data.models

import com.example.apirequestssession.features.todo.domain.entities.PostEntity
import com.google.gson.annotations.SerializedName

data class PostModel(
    @SerializedName("userId")  var userId: Int,
    @SerializedName("id")  var id: Int,
    @SerializedName("title")  var title: String,
    @SerializedName("body")  var body: String)

fun PostModel.toEntity(): PostEntity {
    return PostEntity(
        this.userId,
        this.id,
        this.title,
        this.body
    )
}