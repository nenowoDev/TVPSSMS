package com.example.controller;

import com.example.entity.Program;
import com.example.service.ProgramDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/program")
public class ProgramController {

    private final ProgramDAO programDAO;

    @Autowired
    public ProgramController(ProgramDAO programDAO) {
        this.programDAO = programDAO;
    }

    // View all programs
    @GetMapping("/view")
    public String viewContent(Model model) {
        List<Program> programs = programDAO.findAll();
        programs.forEach(System.out::println); // Log each program
        model.addAttribute("programs", programs);
        return "program/view";
    }

    // Show the form to add a new program
    @GetMapping("/add")
    public String addProgramForm(Model model) {
        model.addAttribute("program", new Program());
        return "program/add";
    }

    // Handle the submission of the form to add a program
    @PostMapping("/add")
    public String addProgram(@ModelAttribute("program") Program program) {
        programDAO.save(program);
        return "redirect:/program/view";
    }

    @GetMapping("/edit/{id}")
    public String editProgramForm(@PathVariable Long id, Model model) {
        Program program = programDAO.findById(id);
        model.addAttribute("program", program);
        return "program/edit"; // Points to the Thymeleaf template
    }

    @PostMapping("/edit")
    public String updateProgram(@ModelAttribute("program") Program program) {
        programDAO.update(program);
        return "redirect:/program/view"; // Redirect to program list
    }
    // Delete a program by name
 // Delete a program by ID
    @GetMapping("/delete/{id}")
    public String deleteProgram(@PathVariable Long id) {
        programDAO.deleteById(id); // Use ID instead of programName
        return "redirect:/program/view";
    }
}
