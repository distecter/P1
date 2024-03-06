package com.sparta.todo.comment.dto

import com.sparta.todo.comment.model.Comment

data class CommentResponse (
    val id: Long?,
    val nickname: String,
    val content: String
) {
    companion object {
        fun toCommentResponse(comment: Comment): CommentResponse {
            return CommentResponse(
                id = comment.id,
                nickname = comment.nickname,
                content = comment.content
            )
        }
    }
}