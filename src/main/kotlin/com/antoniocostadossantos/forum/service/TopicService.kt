package com.antoniocostadossantos.forum.service

import com.antoniocostadossantos.forum.dto.NewTopicForm
import com.antoniocostadossantos.forum.dto.TopicView
import com.antoniocostadossantos.forum.dto.UpdateTopicForm
import com.antoniocostadossantos.forum.mapper.TopicFormMapper
import com.antoniocostadossantos.forum.mapper.TopicViewMapper
import com.antoniocostadossantos.forum.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
        private var topics: List<Topic> = emptyList(),
        private val topicViewMapper: TopicViewMapper,
        private val topicFormMapper: TopicFormMapper
) {

    fun listar(): List<TopicView> {
        return topics.map {
            topicViewMapper.map(it)
        }
    }

    fun getById(id: Long): TopicView {

        return topics.filter {
            it.id == id
        }.map {
            topicViewMapper.map(it)
        }.first()
    }

    fun registerTopic(newTopicForm: NewTopicForm) {
        val topic = topicFormMapper.map(newTopicForm)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
    }

    fun updateTopic(topicDto: UpdateTopicForm) {
        val topic = topics.filter { it.id == topicDto.id }.first()
        topics = topics.minus(topic).plus(Topic(
                id = topicDto.id,
                title = topicDto.title,
                message = topicDto.message,
                author = topic.author,
                course = topic.course,
                answers = topic.answers,
                status = topic.status,
                createdAt = topic.createdAt
        ))
    }

    fun deleteTopic(id: Long) {
        val topic = topics.filter { it.id == id }.first()
        topics = topics.minus(topic)
    }

}