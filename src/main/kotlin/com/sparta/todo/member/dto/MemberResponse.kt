package com.sparta.todo.member.dto

import com.sparta.todo.member.model.Member


data class MemberResponse (
    val id: Long,
    val email: String,
    val nickname: String
) {
    companion object {
        fun from(member: Member): MemberResponse {
            return MemberResponse(
                id = member.id,
                email = member.email,
                nickname = member.nickname
            )
        }
    }
}
