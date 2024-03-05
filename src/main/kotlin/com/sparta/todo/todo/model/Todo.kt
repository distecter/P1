package com.sparta.todo.todo.model

import com.sparta.todo.todo.dto.TodoResponse
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@Entity
@Table(name = "todo")
class Todo (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "content", nullable = false)
    var content: String,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "createdAt")
    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "nickname")
    var nickname: String

)

fun Todo.toResponse(): TodoResponse {
    return TodoResponse(
            id = id!!,
            nickname = nickname,
            title = title,
            content = content,
            createdAt = createdAt
    )
}