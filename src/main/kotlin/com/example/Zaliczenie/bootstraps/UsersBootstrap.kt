package com.example.Zaliczenie.bootstraps

import com.example.Zaliczenie.models.User
import com.example.Zaliczenie.repositories.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class UsersBootstrap(val repository: UserRepository): CommandLineRunner {
    override fun run(vararg args: String?) {
        val adam: User = User(null, "Adam", "Nowak", "nowy.99@wp.pl", 3836);
        val kamil: User = User(null, "Kamil", "Kalinowski", "kal.95@wp.pl", 4993);
        val kasia: User = User(null, "Kasia", "Strzygiel", "kass.96@wp.pl", 4421);

        repository.save(adam);
        repository.save(kamil);
        repository.save(kasia);
    }
}