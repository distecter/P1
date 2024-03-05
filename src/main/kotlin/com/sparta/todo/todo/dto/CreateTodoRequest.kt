package com.sparta.todo.todo.dto

data class CreateTodoRequest (
    val nickname: String,
    val title: String,
    val content: String
)