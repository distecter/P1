package com.sparta.todo.comment.service

import com.sparta.todo.comment.dto.CommentResponse
import com.sparta.todo.comment.model.Comment

interface CommentService {
    fun createComment(todoId: Long, nickname: String, content: String): CommentResponse

    fun updateComment(commentId: Long, content: String): CommentResponse

    fun deleteComment(commentId: Long)

    fun getCommentById(commentId: Long): Comment
}