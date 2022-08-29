package com.example.ko.controller

import com.example.ko.domain.member.MemberEntity
import com.example.ko.dto.MemberDto
import com.example.ko.service.member.MemberService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/member")
class MemberController (
    private val memberService: MemberService,
){
    @GetMapping("/{name}")
    fun getMember(@PathVariable(value = "name") name: String): ResponseEntity<MemberEntity> {
        return ResponseEntity.ok(memberService.findMember(name).get())
    }

    @PostMapping("")
    fun insertMember(@RequestBody memberDto: MemberDto): ResponseEntity<Any> {
        memberService.save(memberDto)
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 완료")
    }
}