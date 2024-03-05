package com.sparta.todo.member.service

import com.sparta.todo.member.dto.CreateMemberRequest
import com.sparta.todo.member.dto.MemberResponse
import com.sparta.todo.member.dto.UpdateMemberRequest

interface MemberService {
    fun createMember(createMemberRequest: CreateMemberRequest)

    fun findById(id: Long): MemberResponse

    fun findAll(): List<MemberResponse>

    fun updateMember(id:Long ,updateMemberRequest: UpdateMemberRequest): MemberResponse

    fun deleteMember(id: Long)
}