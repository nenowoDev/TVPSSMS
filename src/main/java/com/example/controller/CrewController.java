package com.example.controller;

import com.example.entity.Crew;
import com.example.service.CrewDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/crew")
public class CrewController {

    @Autowired
    private CrewDAO crewDAO;

    @GetMapping("/registration")
    public String viewRegistrationPage(Model model) {
        List<Crew> crewList = crewDAO.findAll();
        model.addAttribute("crewList", crewList);
        return "crew/registration";
    }
    
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("crew", new Crew()); // Add a new Crew object to the model
        return "crew/register"; // Return the form view
    }


    @PostMapping("/register")
    public String registerCrew(@ModelAttribute Crew crew) {
        crewDAO.saveOrUpdate(crew);
        return "redirect:/crew/registration";
    }

    @GetMapping("/delete/{id}")
    public String deleteCrew(@PathVariable int id) {
        crewDAO.deleteById(id);
        return "redirect:/crew/registration";
    }
}
