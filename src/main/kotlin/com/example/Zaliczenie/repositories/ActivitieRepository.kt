package com.example.Zaliczenie.repositories

import com.example.Zaliczenie.models.Activitie
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface ActivitieRepository: CrudRepository<Activitie, Long> {
    @Query(value = "select * from Activitie a where a.name = :name", nativeQuery = true)
    fun findByName(@Param("name") name: String): Activitie;
}