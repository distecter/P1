package com.sparta.todo.comment.model

import jakarta.persistence.Column
import org.springframework.data.annotation.CreatedDate

data class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "content")
    var content: String,

    @Column(name = "createdAt")
    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()
)
