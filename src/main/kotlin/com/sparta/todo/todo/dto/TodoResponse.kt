package com.sparta.todo.todo.dto

import java.time.LocalDateTime

data class TodoResponse(
    val id: Long,
    val nickname: String,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime
)
