package com.sparta.todo.comment.dto

data class CreateCommentRequest (
    val todoId: Long,
    val nickname: String,
    val content: String
)