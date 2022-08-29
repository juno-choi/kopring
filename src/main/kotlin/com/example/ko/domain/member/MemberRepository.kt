package com.example.ko.domain.member

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MemberRepository : JpaRepository<MemberEntity, Long>{
    fun findByName(name: String): Optional<MemberEntity>
}