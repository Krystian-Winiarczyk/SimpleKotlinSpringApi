package com.example.Zaliczenie.repositories

import com.example.Zaliczenie.models.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository: CrudRepository<User, Long> {
    override fun findById(id: Long): Optional<User>;
}