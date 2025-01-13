package com.example.controller;

import com.example.entity.Crew;
import com.example.entity.Task;
import com.example.service.CrewDAO;
import com.example.service.TaskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/crew/task")
@PreAuthorize("hasRole('TEACHER')")
public class TaskController {

    @Autowired
    private TaskDAO taskDAO;

    @Autowired
    private CrewDAO crewDAO;

    // Display all tasks
    @GetMapping
    public String viewTaskPage(Model model) {
        List<Task> taskList = taskDAO.findAll();
        model.addAttribute("taskList", taskList);
        return "crew/task";
    }

    // Show form to add or edit a task
    @GetMapping("/form")
    public String showTaskForm(@RequestParam(required = false) Integer id, Model model) {
        Task task = (id != null) ? taskDAO.findById(id) : new Task();
        List<Crew> crewList = crewDAO.findAll();
        model.addAttribute("task", task);
        model.addAttribute("crewList", crewList);
        return "crew/task-form";
    }

    // Save or update a task
    @PostMapping("/save")
    public String saveTask(@ModelAttribute Task task, @RequestParam int crewId) {
        Crew crew = crewDAO.findById(crewId);
        if (crew != null) {
            task.setCrew(crew); // Assign the crew
            taskDAO.saveOrUpdate(task); // Save the task
        } else {
            // Handle the case where crew is not found, maybe show an error
            // For now, we'll assume crew is required and just redirect back
            return "redirect:/crew/task";
        }
        return "redirect:/crew/task";
    }

    // Delete a task by ID
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        taskDAO.deleteById(id);
        return "redirect:/crew/task";
    }

}
