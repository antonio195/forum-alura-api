package com.antoniocostadossantos.forum.controller

import com.antoniocostadossantos.forum.dto.NewTopicDto
import com.antoniocostadossantos.forum.model.Topic
import com.antoniocostadossantos.forum.service.TopicService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topics")
class TopicController(
    private val service: TopicService
) {

    @GetMapping
    fun listTopics(): List<Topic> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun getTopicById(@PathVariable id: Long): Topic {
        return service.getById(id)
    }

    @PostMapping
    fun postTopic(@RequestBody topicDto: NewTopicDto) {
        service.registerTopic(topicDto)
    }

}