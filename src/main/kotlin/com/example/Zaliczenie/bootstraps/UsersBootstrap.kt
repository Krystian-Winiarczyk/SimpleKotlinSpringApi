package com.example.Zaliczenie.bootstraps

import com.example.Zaliczenie.models.Activitie
import com.example.Zaliczenie.models.User
import com.example.Zaliczenie.repositories.ActivitieRepository
import com.example.Zaliczenie.repositories.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class UsersBootstrap(val userRepository: UserRepository, val activitieRepository: ActivitieRepository): CommandLineRunner {
    override fun run(vararg args: String?) {
        val math = Activitie(1, "Mathematics");
        val laboratory = Activitie(2, "Laboratory");
        val algorithm = Activitie(3, "Algorithm");

        val adam: User = User("Adam", "Nowak", "nowy.99@wp.pl", 3836, listOf(math, laboratory));
        val kamil: User = User("Kamil", "Kalinowski", "kal.95@wp.pl", 4993, listOf(laboratory));
        val kasia: User = User("Kasia", "Strzygiel", "kass.96@wp.pl", 4421, listOf(algorithm, laboratory, math));


        activitieRepository.saveAll(listOf(math, algorithm, laboratory));
        userRepository.saveAll(listOf(adam, kamil, kasia));
    }
}