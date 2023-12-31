package com.antoniocostadossantos.forum.controller

import com.antoniocostadossantos.forum.dto.NewTopicForm
import com.antoniocostadossantos.forum.dto.TopicView
import com.antoniocostadossantos.forum.dto.UpdateTopicForm
import com.antoniocostadossantos.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/topics")
class TopicController(
        private val service: TopicService
) {

    @GetMapping
    fun listTopics(): List<TopicView> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun getTopicById(@PathVariable id: Long): TopicView {
        return service.getById(id)
    }

    @PostMapping
    fun postTopic(@RequestBody @Valid topicDto: NewTopicForm): ResponseEntity<TopicView> {
        val topicView = service.registerTopic(topicDto)
        val uri = URI.create()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    fun updateTopic(@RequestBody @Valid topicDto: UpdateTopicForm) {
        service.updateTopic(topicDto)
    }

    @DeleteMapping("/{id}")
    fun deleteTopic(@PathVariable id: Long) {
        service.deleteTopic(id)
    }

}