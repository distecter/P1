package com.sparta.todo.comment.model

import com.sparta.todo.todo.model.Todo
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@Entity
data class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(name = "nickname")
    var nickname: String,

    @Column(name = "content")
    var content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id", nullable = false)
    var todo: Todo,

    @Column(name = "createdAt")
    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()
)
