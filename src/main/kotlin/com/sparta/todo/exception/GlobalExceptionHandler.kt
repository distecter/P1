package com.sparta.todo.exception

import com.sparta.todo.global.exception.ErrorResponse
import com.sparta.todo.global.exception.ModelNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(ModelNotFoundException::class)
    fun handleModelNotFoundException(e: ModelNotFoundException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse(e.message))
    }
}