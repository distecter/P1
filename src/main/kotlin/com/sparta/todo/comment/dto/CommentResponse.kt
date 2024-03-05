package com.sparta.todo.comment.dto

import com.sparta.todo.comment.model.Comment

data class CommentResponse (
    val id: Long,
    val todoId: Long,
    val nickname: String,
    val content: String
) {
    companion object {
        fun from(comment: Comment): CommentResponse {
            return CommentResponse(
                id = comment.id,
                todoId = comment.todo.id,
                nickname = comment.member.nickname,
                content = comment.content
            )
        }
    }
}