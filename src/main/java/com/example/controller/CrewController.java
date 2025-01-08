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
    
    @GetMapping("/review/{id}")
    public String reviewCrew(@PathVariable int id, Model model) {
        // Fetch the Crew by ID to show their details
        Crew crew = crewDAO.findById(id);
        model.addAttribute("crew", crew);  // Add crew object to the model for review
        return "crew/review";  // Return the review page view
    }

    @PostMapping("/approve/{id}")
    public String approveCrew(@PathVariable int id) {
        // Fetch the Crew by ID
        Crew crew = crewDAO.findById(id);
        if (crew != null) {
            crew.setStatus("Approved");  // Update the status to 'Approved'
            crewDAO.saveOrUpdate(crew);  // Save the changes
        }
        return "redirect:/crew/registration";  // Redirect back to the registration list
    }

    @PostMapping("/reject/{id}")
    public String rejectCrew(@PathVariable int id) {
        // Fetch the Crew by ID
        Crew crew = crewDAO.findById(id);
        if (crew != null) {
            crew.setStatus("Rejected");  // Update the status to 'Rejected'
            crewDAO.saveOrUpdate(crew);  // Save the changes
        }
        return "redirect:/crew/registration";  // Redirect back to the registration list
    }

}
