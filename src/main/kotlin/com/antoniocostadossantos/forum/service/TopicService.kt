package com.antoniocostadossantos.forum.service

import com.antoniocostadossantos.forum.dto.NewTopicDto
import com.antoniocostadossantos.forum.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = emptyList(),
    private val courseService: CourseService,
    private val userService: UserService
) {

    fun listar(): List<Topic> {
        return topics
    }

    fun getById(id: Long): Topic {
        return topics.stream().filter {
            it.id == id
        }.findFirst().get()
    }

    fun registerTopic(topic: NewTopicDto) {
        topics = topics.plus(
            Topic(
                id = topics.size.toLong() + 1,
                title = topic.title,
                message = topic.message,
                course = courseService.getById(topic.courseId),
                author = userService.getById(topic.courseId),
            )
        )
    }

}