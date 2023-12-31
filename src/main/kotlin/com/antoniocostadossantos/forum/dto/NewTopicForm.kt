package com.antoniocostadossantos.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class NewTopicForm(
        @field:NotEmpty
        val title: String,

        @field:NotEmpty
        val message: String,

        @field:NotNull
        val courseId: Long,

        @field:NotNull
        val authorId: Long,
)
