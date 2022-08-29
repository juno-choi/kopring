package com.example.ko.service.member

import com.example.ko.domain.member.MemberEntity
import com.example.ko.domain.member.MemberRepository
import com.example.ko.dto.MemberDto
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional

@SpringBootTest
class MemberServiceImplTest(
    @Autowired val memberService: MemberService,
    @Autowired val memberRepository: MemberRepository,
){
    @Test
    @DisplayName("member findByName에 성공한다.")
    @Transactional
    fun memberFind(){
        //given
        val member = MemberEntity("juno", "juno@mail.com", "01012341234")
        memberRepository.save(member)
        //when
        val findMember = memberService.findMember("juno").get()
        //then
        assertEquals(findMember.name, member.name)
    }

    @Test
    @DisplayName("member save에 성공한다.")
    fun memberSave(){
        //given
        val memberDto = MemberDto("juno", "juno@mail.com", "01012341234")
        //when
        memberService.save(memberDto)
        //then
        val findByName = memberRepository.findByName("juno").get()
        assertEquals(findByName.name, "juno")
    }
}