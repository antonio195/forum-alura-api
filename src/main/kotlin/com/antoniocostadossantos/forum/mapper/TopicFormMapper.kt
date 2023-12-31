package com.antoniocostadossantos.forum.mapper

import com.antoniocostadossantos.forum.dto.NewTopicForm
import com.antoniocostadossantos.forum.model.Topic
import com.antoniocostadossantos.forum.service.CourseService
import com.antoniocostadossantos.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
        private val courseService: CourseService,
        private val userService: UserService,
) : Mapper<NewTopicForm, Topic> {

    override fun map(t: NewTopicForm): Topic {
        return Topic(
                title = t.title,
                message = t.message,
                course = courseService.getById(t.courseId),
                author = userService.getById(t.courseId),
        )
    }

}
