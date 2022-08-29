package com.example.ko.dto

class UserDto (
    var name: String,
    val email: String,
    val phone: String? =null,
){
    fun changeName(name: String){
        this.name = name
    }
}