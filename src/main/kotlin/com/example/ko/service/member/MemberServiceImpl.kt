package com.example.ko.service.member

import com.example.ko.domain.member.MemberEntity
import com.example.ko.domain.member.MemberRepository
import com.example.ko.dto.MemberDto
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
class MemberServiceImpl(
    private val memberRepository: MemberRepository,
) : MemberService{
    override fun findMember(name: String): Optional<MemberEntity> {
        return memberRepository.findByName(name)
    }

    @Transactional
    override fun save(memberDto: MemberDto) {
        memberRepository.save(MemberEntity(memberDto.name, memberDto.email, memberDto.phone))
    }
}