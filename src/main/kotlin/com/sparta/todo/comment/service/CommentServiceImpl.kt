package com.sparta.todo.comment.service

import com.sparta.todo.comment.dto.CommentResponse
import com.sparta.todo.comment.dto.CreateCommentRequest
import com.sparta.todo.comment.dto.UpdateCommentRequest
import com.sparta.todo.comment.model.Comment
import com.sparta.todo.comment.repository.CommentRepository
import com.sparta.todo.todo.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CommentServiceImpl (
    private val commentRepository: CommentRepository,
    private val todoRepository: TodoRepository
) : CommentService {
    override fun createComment(todoId: Long, createCommentRequest: CreateCommentRequest): CommentResponse {
        val targetTodo = todoRepository.findByIdOrNull(todoId)
                ?: throw TargetNotFoundException("target todo is not found")

        val comment = Comment(
                content = createCommentRequest.content,
                todo = targetTodo,
                createdAt = LocalDateTime.now(),
        )

        val result = commentRepository.save(comment)

        return CommentResponse
                .toCommentResponse(result)
    }

    override fun updateComment(commentId: Long, request: UpdateCommentRequest): CommentResponse {
        val comment = commentRepository.findByIdOrNull(commentId) ?: throw ModelNotFoundException("Comment", commentId)

        comment.content = request.content

        return CommentResponse.toCommentResponse(comment)
    }

    override fun deleteComment(commentId: Long) {
        val comment = commentRepository.findByIdOrNull(commentId) ?: throw ModelNotFoundException("Comment", commentId)

        commentRepository.delete(comment)
    }

    override fun getCommentById(commentId: Long): Comment {
        val comment = commentRepository.findByIdOrNull(commentId) ?: throw ModelNotFoundException("Comment", commentId)
    }
}