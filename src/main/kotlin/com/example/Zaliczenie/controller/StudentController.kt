package com.example.Zaliczenie.controller

import com.example.Zaliczenie.models.User
import com.example.Zaliczenie.repositories.UserRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import java.lang.Exception

@Controller
class StudentController(val userRepository: UserRepository) {

    @GetMapping("/")
    private fun getStudents(model: Model): String {
        model["users"] = userRepository.findAll();
        return "index";
    }

    @GetMapping("/showCreateUser")
    private fun getCreateUserPage(model: Model): String {
        model["user"] = User();
        return "newUser";
    }

    @PostMapping("/createUser")
    private fun createUser(@ModelAttribute(value = "user") user: User, model: Model): String {
        try {
            userRepository.save(user);
            model["success"] = "User created";
        } catch (e: Exception) {
            model["error"] = e.message!!;
            return "error";
        }

        return "newUser";
    };
}