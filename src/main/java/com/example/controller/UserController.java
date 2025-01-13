package com.example.controller;

import com.example.entity.User;
import com.example.service.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Render custom login page
    @GetMapping("/loginrole")
    public String showLoginRolePage() {
        return "user/loginrole"; // Points to user/loginrole.html
    }

    // Handle login submission
    @PostMapping("/loginrole")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            @RequestParam("role") String role, // Capturing role from the form
                            Model model) {
        User user = userDAO.findByUsername(username);

        if (user != null) {
            // Verify password
            boolean isPasswordValid = passwordEncoder.matches(password, user.getPassword());

            // Verify role
            boolean isRoleValid = user.getAuthorities().stream()
                    .anyMatch(auth -> auth.getAuthority().equalsIgnoreCase(role));

            if (isPasswordValid && isRoleValid) {
                model.addAttribute("message", "Welcome, " + username + " (" + role + ")!");
                return "welcome"; // Redirect to a welcome page upon successful login
            }
        }

        // Login failed, return with error
        model.addAttribute("error", "Invalid username, password, or role.");
        return "user/loginrole";
    }
}
