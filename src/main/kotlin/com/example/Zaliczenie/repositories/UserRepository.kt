package com.example.Zaliczenie.repositories

import com.example.Zaliczenie.models.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long> {

}