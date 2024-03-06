package com.sparta.todo.member.controller

import com.sparta.todo.member.dto.CreateMemberRequest
import com.sparta.todo.member.dto.MemberResponse
import com.sparta.todo.member.service.MemberService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/members")
class MemberController (
    val memberService: MemberService
) {
    @PostMapping
    fun createMember(
        @RequestBody createMemberRequest: CreateMemberRequest
    ): ResponseEntity<MemberResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(memberService.createMember(createMemberRequest))
    }

    @GetMapping
    fun findAllMember(): ResponseEntity<List<MemberResponse>>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(memberService.findAll())
    }

    @GetMapping("/{memberId}")
    fun findMember(
        @PathVariable memberId: Long
    ): ResponseEntity<MemberResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(memberService.findById(memberId))
    }

    @DeleteMapping("/{memberId}")
    fun deleteMember(
        @PathVariable memberId: Long
    ): ResponseEntity<Unit> {
        memberService.deleteMember(memberId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }
}