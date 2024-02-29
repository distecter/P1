package com.sparta.todo.comment.controller

import org.springframework.web.bind.annotation.*


@RequestMapping("/todos/{todoId}/comments")
@RestController
class CommentController (
    private val commentService: CommentService
){

    @PostMapping
    fun createComment(
        @RequestParam todoId: Long,
        @RequestBody createCommentRequest: CreateCommentRequest
    ): ResponseEntity<CommentResponse> {

        val result = commentService.createComment(todoId, createCommentRequest)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(result)
    }

    @PutMapping("/{commentId}")
    fun updateComment(
        @PathVariable commentId: Long,
        @RequestBody updateCommentRequest: UpdateCommentRequest
    ): ResponseEntity<CommentResponse> {
        val updateComment = commentService.updateComment(commentId, updateCommentRequest)

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(updateComment)
    }

    @DeleteMapping(" /{commentId}")
    fun deleteComment(
        @PathVariable commentId: Long
    ): ResponseEntity<String> {

        commentService.deleteComment(commentId)
        val deleteCommentSuccessMessage = "댓글이 성공적으로 삭제되었습니다."

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(deleteCommentSuccessMessage)

    }
}
)