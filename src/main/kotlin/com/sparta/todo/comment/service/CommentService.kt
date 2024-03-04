package com.sparta.todo.comment.service

interface CommentService {
    fun createComment(todoId: Long, nickname: String, content: String)

    fun updateComment(commentId: Long, content: String)

    fun deleteComment(commentId: Long)

    fun getComment(commentId: Long)
}