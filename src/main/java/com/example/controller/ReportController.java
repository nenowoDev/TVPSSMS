package com.example.controller;

import com.example.entity.Program;
import com.example.service.ProgramDAO;
import com.example.entity.Report;
import com.example.service.ReportDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
	

@Controller
@RequestMapping("/report")
public class ReportController {

    private final ReportDAO reportDAO;
    private final ProgramDAO programDAO;

    @Autowired
    public ReportController(ReportDAO reportDAO, ProgramDAO programDAO) {
        this.reportDAO = reportDAO;
        this.programDAO = programDAO;
    }

    @GetMapping("/view")
    public String viewPrograms(Model model) {
        List<Program> programs = programDAO.findAll(); // Fetch programs from the database
        model.addAttribute("programs", programs);     // Add them to the model
        return "report/view";                         // Return the view name
    }

    @GetMapping("/add/{programId}")
    public String addReportForm(@PathVariable Long programId, Model model) {
        Program program = programDAO.findById(programId); // Directly fetch the program
        if (program == null) {
            throw new IllegalArgumentException("Program not found for ID: " + programId); // Handle null case
        }

        Report report = new Report();
        report.setProgram(program); // Link the report to the program
        model.addAttribute("report", report);
        return "report/add"; // Return the add report form
    }


    // Step 2: Handle the form submission to save the report
    @PostMapping("/add")
    public String saveReport(@ModelAttribute("report") Report report) {
        reportDAO.save(report); // Save the report to the database
        return "redirect:/report/view"; // Redirect to the list of programs
    }
    
    @GetMapping("/view/{reportId}")
    public String viewReport(@PathVariable Long reportId, Model model) {
        Report report = reportDAO.findById(reportId); // Fetch the report
        model.addAttribute("report", report);
        return "report/view-report"; // Point to a detailed view template
    }

}

 

