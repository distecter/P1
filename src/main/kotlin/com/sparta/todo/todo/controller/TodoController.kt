package com.sparta.todo.todo.controller

import com.sparta.todo.todo.dto.CreateTodoRequest
import com.sparta.todo.todo.dto.TodoResponse
import com.sparta.todo.todo.dto.UpdateTodoRequest
import com.sparta.todo.todo.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/(todos")
class TodoController (
    private val todoService: TodoService
) {
    @GetMapping
    fun getTodoList(): ResponseEntity<List<TodoResponse>> {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todoService.getAllTodoList())
    }

    @GetMapping("/{todoId}")
    fun getTodo(@PathVariable todoId: Long): ResponseEntity<TodoResponse> {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todoService.getTodoById(todoId))
    }

    @PostMapping
    fun createTodo(@RequestBody createTodoRequest: CreateTodoRequest): ResponseEntity<TodoResponse> {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(todoService.createTodo(createTodoRequest))
    }

    @PutMapping("/{todoId}")
    fun updateTodo(
            @PathVariable todoId: Long,
            @RequestBody updateTodoRequest: UpdateTodoRequest
    ): ResponseEntity<TodoResponse> {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todoService.updateTodo(todoId, updateTodoRequest))
    }

    @DeleteMapping("/{todoId}")
    fun deleteTodo(@PathVariable todoId: Long): ResponseEntity<String> {
        todoService.deleteTodo(todoId)
        val deleteTodoSuccessMessage = "할 일이 성공적으로 삭제되었습니다."
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(deleteTodoSuccessMessage)
    }
}