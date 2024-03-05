package com.sparta.todo.member.service

import com.sparta.todo.global.exception.ModelNotFoundException
import com.sparta.todo.member.dto.CreateMemberRequest
import com.sparta.todo.member.dto.MemberResponse
import com.sparta.todo.member.dto.UpdateMemberRequest
import com.sparta.todo.member.repository.MemberRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MemberServiceImpl (
    private val memberRepository: MemberRepository
): MemberService {
    override fun createMember(createMemberRequest: CreateMemberRequest): MemberResponse {
        val saveMember = memberRepository.save(createMemberRequest.to())
        return MemberResponse.from(saveMember)
    }

    override fun findById(id: Long): MemberResponse {
        val foundMember = memberRepository.findByIdOrNull(id) ?: throw ModelNotFoundException("Member", id)
        return foundMember.let { MemberResponse.from(it) }
    }

    override fun findAll(): List<MemberResponse> {
        return memberRepository.findAll().map { MemberResponse.from(it) }
    }

    override fun updateMember(id: Long, updateMemberRequest: UpdateMemberRequest): MemberResponse {
        val saveMember = memberRepository.findByIdOrNull(id) ?: throw ModelNotFoundException("Member", id)
        saveMember.nickname = updateMemberRequest.nickname
        return MemberResponse.from(memberRepository.save(saveMember))
    }

    override fun deleteMember(id: Long) {
        memberRepository.deleteById(id)
    }
}