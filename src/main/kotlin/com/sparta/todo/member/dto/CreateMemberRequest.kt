package com.sparta.todo.member.dto

import com.sparta.todo.member.model.Member

data class CreateMemberRequest(
    val email: String,
    val nickname: String
) {
    fun to(): Member {
        return Member(
            email = email,
            nickname = nickname
        )
    }
}
