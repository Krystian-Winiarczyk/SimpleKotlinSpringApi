package com.example.Zaliczenie.models

import javax.persistence.*

@Entity
@Table(name = "users")
class User(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = 0,
        var name: String = "",
        var surename: String = "",
        var email: String = "",
        var indexNumber: Int = 0
) {
}