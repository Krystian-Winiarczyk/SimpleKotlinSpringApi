package com.example.Zaliczenie.models

import javax.persistence.*

@Entity
@Table(name = "user")
class User(
        var name: String = "",
        var surname: String = "",
        var email: String = "",
        var indexNumber: Int = 0,
        @ManyToMany(cascade = arrayOf(CascadeType.ALL))
        @JoinTable(
                name = "user_activities",
                joinColumns = arrayOf(JoinColumn(name = "user_id", referencedColumnName = "id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "activitie_id", referencedColumnName = "id"))
        )
        var activities: List<Activitie> = mutableListOf<Activitie>(),
        @Column(columnDefinition = "LONGTEXT", nullable = false)
        var userPhoto: String = "",

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = 0,
) {
        override fun toString(): String {
                return "User(name='$name', surname='$surname', email='$email', indexNumber=$indexNumber, userPhoto='$userPhoto', id=$id)"
        }
}