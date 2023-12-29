package com.antoniocostadossantos.forum.service

import com.antoniocostadossantos.forum.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService(
    var courses: List<Course>
) {

    init {
        val course = Course(
            id = 1,
            name = "Kotlin",
            category = "Programacao"
        )

        courses = listOf(course)
    }

    fun getById(id: Long): Course {
        return courses.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }

}
