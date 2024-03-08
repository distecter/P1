package com.sparta.todo.comment.service

import com.sparta.todo.comment.dto.CommentResponse
import com.sparta.todo.comment.dto.CreateCommentRequest
import com.sparta.todo.comment.dto.UpdateCommentRequest
import com.sparta.todo.comment.model.Comment
import com.sparta.todo.comment.repository.CommentRepository
import com.sparta.todo.global.exception.ModelNotFoundException
import com.sparta.todo.global.exception.TargetNotFoundException
import com.sparta.todo.todo.repository.TodoRepository
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CommentServiceImpl (
    private val commentRepository: CommentRepository,
    private val todoRepository: TodoRepository
) : CommentService {

    @Transactional
    override fun createComment(todoId: Long, nickname: String, content: String): CommentResponse{
        val targetTodo = todoRepository.findByIdOrNull(todoId)
            ?: throw TargetNotFoundException(
                targetName = "Todo",
                id = todoId
            )

        val comment = Comment(
            content = content,
            todo = targetTodo,
            createdAt = LocalDateTime.now(),
            nickname = nickname,
            id = null
        )
        val result = commentRepository.save(comment)

        return CommentResponse
                .toCommentResponse(result)
    }

    @Transactional
    override fun updateComment(commentId: Long, content: String): CommentResponse {
        val comment = commentRepository.findByIdOrNull(commentId) ?: throw ModelNotFoundException("Comment", commentId)

        comment.content = content

        return CommentResponse.toCommentResponse(comment)
    }

    @Transactional
    override fun deleteComment(commentId: Long) {
        val comment = commentRepository.findByIdOrNull(commentId) ?: throw ModelNotFoundException("Comment", commentId)

        commentRepository.delete(comment)
    }

    override fun getCommentById(commentId: Long): Comment {
        val comment = commentRepository.findByIdOrNull(commentId) ?: throw ModelNotFoundException("Comment", commentId)
        return comment
    }
}