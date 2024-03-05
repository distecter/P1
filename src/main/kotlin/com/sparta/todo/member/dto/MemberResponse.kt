package com.sparta.todo.member.dto

import java.lang.reflect.Member

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
