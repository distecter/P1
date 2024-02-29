package com.sparta.todo.todo.service

interface TodoService {

    fun createTodo()

    fun updateTodo()

    fun deleteTodo()

    fun getTodoById()

    fun getTodos()

    fun getTodosByUserId()

    fun getTodosByCategoryId()
}