package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.entity.User;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final List<User> users = new ArrayList<>(); // In-memory user list (simulate a database)

    // Show login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "user/login"; // Maps to /WEB-INF/views/login.jsp
    }

    // Handle login
    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                model.addAttribute("message", "Welcome, " + user.getUsername() + "!");
                return "welcome"; // Maps to /WEB-INF/views/welcome.jsp
            }
        }
        model.addAttribute("error", "Invalid username or password.");
        return "user/login"; // Stay on the login page
    }

    // Show registration page
    @GetMapping("/register")
    public String showRegistrationPage() {
        return "user/register"; // Maps to /WEB-INF/views/register.jsp
    }

    // Handle registration
    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password,
                               @RequestParam String role, Model model) {
        users.add(new User(username, password, role));
        model.addAttribute("message", "User registered successfully!");
        return "user/register";
    }
}
