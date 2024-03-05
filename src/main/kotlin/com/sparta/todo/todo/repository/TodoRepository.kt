package com.sparta.todo.todo.repository

import com.sparta.todo.todo.model.Todo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository: JpaRepository<Todo, Long> {

    fun findByTitleLike(title: String, content: String, pageable: Pageable): Page<Todo>

    fun findAllByOrderByCreatedAtDesc(pageable: Pageable): Page<Todo>
}