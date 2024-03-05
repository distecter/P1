package com.sparta.todo.global.exception

data class TargetNotFoundException (val targetName: String, val id: Long?):
        RuntimeException("Target ${targetName} not found with given id: ${id}") {
}