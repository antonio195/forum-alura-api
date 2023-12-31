package com.antoniocostadossantos.forum.mapper

import com.antoniocostadossantos.forum.dto.TopicView
import com.antoniocostadossantos.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<Topic, TopicView> {

    override fun map(t: Topic): TopicView {
        return TopicView(
                id = t.id,
                title = t.title,
                message = t.message,
                status = t.status,
                createdAt = t.createdAt
        )
    }
}