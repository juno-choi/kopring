package com.example.ko.service.member

import com.example.ko.domain.member.MemberEntity
import com.example.ko.dto.MemberDto
import java.util.*

interface MemberService {
    fun findMember(name: String): Optional<MemberEntity>
    fun save(memberDto: MemberDto)
}