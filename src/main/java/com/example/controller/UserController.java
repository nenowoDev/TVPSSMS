package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.entity.User;
import com.example.entity.UserRole;
import com.example.service.UserDAO;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/login")
    public String showLoginPage() {
        return "user/login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userDAO.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            model.addAttribute("message", "Welcome, " + user.getUsername() + "!");
            return "welcome";
        }
        model.addAttribute("error", "Invalid username or password.");
        return "user/login";
    }

    @GetMapping("/loginrole")
    public String showLoginRolePage() {
        return "user/loginrole";
    }

    @GetMapping("/register")
    public String showRegistrationPage() {
        return "user/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        try {
            if (user.getUsername() == null || user.getUsername().isEmpty() || 
                user.getPassword() == null || user.getPassword().isEmpty() || 
                user.getRole() == null) {
                model.addAttribute("error", "All fields are required.");
                return "user/register";
            }

            User existingUser = userDAO.getUserByUsername(user.getUsername());
            if (existingUser != null) {
                model.addAttribute("error", "Username already exists. Please choose another.");
                return "user/register";
            }

            userDAO.registerUser(user);
            model.addAttribute("message", "Registration successful! Please log in.");
            return "user/login";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred during registration.");
            return "user/register";
        }
    }
}
