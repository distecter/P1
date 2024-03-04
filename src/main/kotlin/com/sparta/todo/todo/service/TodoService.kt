package com.sparta.todo.todo.service

import com.sparta.todo.todo.dto.CreateTodoRequest
import com.sparta.todo.todo.dto.TodoResponse
import com.sparta.todo.todo.dto.UpdateTodoRequest

interface TodoService {
    fun createTodo(createTodoRequest: CreateTodoRequest): TodoResponse

    fun getTodo(id: Long): TodoResponse

    fun getTodos(): List<TodoResponse>

    fun updateTodo(id: Long, updateTodoRequest: UpdateTodoRequest): TodoResponse

    fun deleteTodo(id: Long)
}