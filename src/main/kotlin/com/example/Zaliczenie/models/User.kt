package com.example.Zaliczenie.models

import javax.persistence.*

@Entity
@Table(name = "users")
class User(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = 0,
        var name: String = "",
        var surname: String = "",
        var email: String = "",
        var indexNumber: Int = 0
) {
        override fun toString(): String {
                return "User(id=$id, name='$name', surname='$surname', email='$email', indexNumber=$indexNumber)"
        }
}