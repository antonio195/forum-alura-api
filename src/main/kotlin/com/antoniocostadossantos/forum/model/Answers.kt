package com.antoniocostadossantos.forum.model

import java.time.LocalDateTime

data class Answers(
    val id: Long? = null,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val topic: Topic,
    val solution: Boolean
)
