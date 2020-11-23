package com.example.Zaliczenie.models

import javax.persistence.*

@Entity
@Table(name = "activitie")
class Activitie(
        @Id
        var id: Long? = 0,
        var name: String = "",
        @ManyToMany(mappedBy = "activities")
        var users: List<User> = mutableListOf<User>(),
) {
}