package com.sparta.todo.member.repository

import com.sparta.todo.member.model.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long> {
}