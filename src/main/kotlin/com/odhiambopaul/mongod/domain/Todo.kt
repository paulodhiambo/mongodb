package com.odhiambopaul.mongod.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "todo")
data class Todo(
    @Id
    val id: String,
    var title: String,
    var description: String,
    var isCompleted: Boolean
)