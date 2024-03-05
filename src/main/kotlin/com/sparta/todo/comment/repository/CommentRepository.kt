package com.sparta.todo.comment.repository

import com.sparta.todo.comment.model.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository<Comment, Long> {
}