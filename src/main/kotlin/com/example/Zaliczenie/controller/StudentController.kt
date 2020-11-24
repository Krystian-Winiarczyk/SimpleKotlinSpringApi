package com.example.Zaliczenie.controller

import com.example.Zaliczenie.models.User
import com.example.Zaliczenie.repositories.ActivitieRepository
import com.example.Zaliczenie.repositories.UserRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.lang.Exception
import java.util.*

@Controller
class StudentController(val userRepository: UserRepository, val activitieRepository: ActivitieRepository) {

    @GetMapping("/")
    private fun getStudents(model: Model, keyword: String): String {
        model["users"] = userRepository.findAll();

        if (keyword != null) {
            model["users"] = userRepository.findByKeyword(keyword);
        }

        return "index";
    }

    @GetMapping("/showCreateUser")
    private fun showCreateUserPage(model: Model): String {
        model["activities"] = activitieRepository.findAll();
        model["user"] = User();
        return "newUser";
    }

    @PostMapping("/createUser")
    private fun createUser(
            @ModelAttribute(value = "user") user: User,
            @RequestParam(value = "image") multipartFile: MultipartFile,
            model: Model): String {

        val imageArray: ByteArray = multipartFile.bytes;
        user.userPhoto = Base64.getEncoder().encodeToString(imageArray);

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
        val user: User = userRepository.findUserById(id);

        if (user != null) {
            model["activities"] = activitieRepository.findAll();
            model["id"] = id;
            model["user"] = user;
        }
        return "editUser";
    }

    @PostMapping("/updateUser/{userId}")
    private fun updateUser(
            @PathVariable("userId") id: Long,
            @RequestParam(value = "image") multipartFile: MultipartFile,
            @ModelAttribute(value = "user") user: User,
            model: Model): String {

        if (multipartFile != null) {
            val imageArray: ByteArray = multipartFile.bytes;
            user.userPhoto = Base64.getEncoder().encodeToString(imageArray);
        }

        user.id = id;
        try {
            userRepository.save(user);
            model["success"] = "User updated";
        } catch (e: Exception) {
            model["error"] = e.message!!;
        }

        return "redirect:/";
    };

    @GetMapping("/error")
    private fun showErrorPage(): String {
        return "error_404";
    }
}