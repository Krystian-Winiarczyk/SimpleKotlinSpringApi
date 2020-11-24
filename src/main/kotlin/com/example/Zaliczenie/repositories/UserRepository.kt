package com.example.Zaliczenie.repositories

import com.example.Zaliczenie.models.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import java.util.*

interface UserRepository: CrudRepository<User, Long> {
    override fun findById(id: Long): Optional<User>;

    @Query(value = "select * from User u where u.name like %:keyword% or u.surname like %:keyword%", nativeQuery = true)
    fun findByKeyword(@Param("keyword") keyword: String): List<User>;
}