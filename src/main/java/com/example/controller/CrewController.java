package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import com.example.model.Crew;

@Controller
@RequestMapping("/crew")
public class CrewController {

    // Mock database for demonstration
    private List<Crew> crewList = new ArrayList<>();
    
    @EventListener(ContextRefreshedEvent.class)
    public void init() {
        crewList.add(new Crew("Ali bin Abu", "ali@example.com", "0123456789", "Leader", 2024));
        crewList.add(new Crew("Aminah Masnawi", "aminah@example.com", "0112233445", "Member", 2023));
    }

    // Display Crew Registration List
    @GetMapping("/registration")
    public String viewRegistration(Model model) {
        model.addAttribute("crewList", crewList); // Pass the list to Thymeleaf
        return "crew/registration"; // Thymeleaf template
    }

    // Display Crew Registration Form
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("crew", new Crew()); // Bind an empty Crew object
        return "crew/register"; // Thymeleaf template for registration form
    }

    // Handle Registration Form Submission
    @PostMapping("/register")
    public String submitRegisterForm(@ModelAttribute Crew crew, Model model) {
        crewList.add(crew); // Save crew to the mock list
        model.addAttribute("crewList", crewList);
        return "redirect:/crew/registration"; // Redirect to the registration list
    }
    
}
