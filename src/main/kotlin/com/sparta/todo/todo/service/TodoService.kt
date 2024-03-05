package com.sparta.todo.todo.service

import com.sparta.todo.todo.dto.CreateTodoRequest
import com.sparta.todo.todo.dto.TodoResponse
import com.sparta.todo.todo.dto.UpdateTodoRequest

interface TodoService {

    fun createTodo(createTodoRequest: CreateTodoRequest)

    fun getAllTodoList(): List<TodoResponse>

    fun getTodoById(id: Long): TodoResponse

    fun updateTodo(id: Long, updateTodoRequest: UpdateTodoRequest): TodoResponse

    fun deleteTodo(id: Long)
}