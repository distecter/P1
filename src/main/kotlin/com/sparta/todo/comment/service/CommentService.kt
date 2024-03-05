package com.sparta.todo.comment.service

import com.sparta.todo.comment.dto.CommentResponse

interface CommentService {
    fun createComment(todoId: Long, nickname: String, content: String)

    fun updateComment(commentId: Long, content: String)

    fun deleteComment(commentId: Long)

    fun getCommentById(commentId: Long): Comment
}