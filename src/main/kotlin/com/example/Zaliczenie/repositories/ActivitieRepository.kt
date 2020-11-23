package com.example.Zaliczenie.repositories

import com.example.Zaliczenie.models.Activitie
import org.springframework.data.repository.CrudRepository

interface ActivitieRepository: CrudRepository<Activitie, Long> {
}