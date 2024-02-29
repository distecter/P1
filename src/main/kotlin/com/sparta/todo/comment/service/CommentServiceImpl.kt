package com.sparta.todo.comment.service

import org.springframework.stereotype.Service

@Service
class CommentServiceImpl {
    fun createComment(todoId: Long, createCommentRequest: CreateCommentRequest): CommentResponse {
        throw UnsupportedOperationException("Not implemented")
    }

    fun updateComment(commentId: Long, request: UpdateCommentRequest): CommentResponse {
        throw UnsupportedOperationException("Not implemented")
    }

    fun deleteComment(commentId: Long) {
        throw UnsupportedOperationException("Not implemented")
    }

    fun getCommentById(commentId: Long): Comment {
        throw UnsupportedOperationException("Not implemented")
    }
}