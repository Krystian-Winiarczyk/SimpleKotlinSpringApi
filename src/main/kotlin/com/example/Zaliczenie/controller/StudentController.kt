package com.example.Zaliczenie.controller

import com.example.Zaliczenie.repositories.UserRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class StudentController(val userRepository: UserRepository) {

    @GetMapping("/")
    private fun getStudents(model: Model): String {
        userRepository.findAll().forEach {
            println(it.email)
        }
        model["users"] = userRepository.findAll();
        return "index";
    }
}