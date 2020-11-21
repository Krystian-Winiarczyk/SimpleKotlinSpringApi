package com.example.Zaliczenie.controller

import com.example.Zaliczenie.models.User
import com.example.Zaliczenie.repositories.UserRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import java.util.*

@Controller
class StudentController(val userRepository: UserRepository) {

    @GetMapping("/")
    private fun getStudents(model: Model): String {
        model["users"] = userRepository.findAll();
        return "index";
    }

    @GetMapping("/showCreateUser")
    private fun showCreateUserPage(model: Model): String {
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
        }

        return "newUser";
    };

    @GetMapping("/editUser/{userId}")
    private fun showEditUserPage(@PathVariable("userId") id: Long, model: Model): String {
        println(id);
        val user: Optional<User> = userRepository.findById(id);
        model["user"] = user;
        return "editUser";
    }

    @GetMapping("/error")
    private fun showErrorPage(): String {
        return "error_404";
    }
}