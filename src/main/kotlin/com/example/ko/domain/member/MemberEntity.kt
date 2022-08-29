package com.example.ko.domain.member

import javax.persistence.*

@Entity
@Table(name = "MEMBER")
class MemberEntity (
    var name: String,
    val email: String,
    val phone: String? =null,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? =null,
){
    fun changeName(name: String){
        this.name = name
    }
}