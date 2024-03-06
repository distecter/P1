package com.sparta.todo.member.model

import jakarta.persistence.*

@Entity
@Table(name="member")
class Member (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(name ="email", nullable = false)
    var email: String,

    @Column(name="nickname", nullable= false)
    var nickname : String
)