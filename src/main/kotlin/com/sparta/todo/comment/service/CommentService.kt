package com.sparta.todo.comment.service

interface CommentService {

    fun createComment (todoId: Long, createCommentRequest: CreateCommentRequest): CommentResponse

    fun updateComment (commentId: Long, request: UpdateCommentRequest): CommentResponse

    fun deleteComment (commentId: Long)

    fun getCommentById(commentId: Long): Comment
}