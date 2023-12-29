package com.antoniocostadossantos.forum.service

import com.antoniocostadossantos.forum.model.User
import org.springframework.stereotype.Service

@Service
class UserService(
    private var authors: List<User>
) {
    init {
        val author = User(
            id = 1,
            name = "Antonio",
            email = "antonio195br@gmail.com",
        )

        authors = listOf(author)
    }

    fun getById(id: Long): User {
        return authors.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }
}
