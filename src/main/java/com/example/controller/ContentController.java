package com.example.controller;

import com.example.entity.Content;
import com.example.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/content")
public class ContentController {

    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    // 1 - View all contents (previously /viewall)    
    @RequestMapping("/")
    public ModelAndView viewAllContent() {
        List<Content> contents = contentService.getAllContent();
        ModelAndView modelAndView = new ModelAndView("content/viewall"); // View name
        modelAndView.addObject("contents", contents);
        return modelAndView;
    }

    // 2 - View content by ID
    @RequestMapping("/{contentID}")
    public ModelAndView viewContentById(@PathVariable String contentID) {
        Content content = contentService.getContentById(contentID);
        ModelAndView modelAndView = new ModelAndView("content/view"); // View name
        if (content != null) {
            modelAndView.addObject("content", content);
        } else {
            modelAndView.addObject("message", "Content not found.");
        }
        return modelAndView;
    }

    
//    TEACHER
    // 3 - Add new content (GET form)
    @RequestMapping("/add")
    public ModelAndView showAddContentForm() {
        ModelAndView modelAndView = new ModelAndView("content/add"); // View name for the form
        modelAndView.addObject("content", new Content());
        return modelAndView;
    }

    // 4 - Handle add content (POST form)
    @RequestMapping("/add/save")
    public ModelAndView addContent(Content content) {
        contentService.createContent(content);
        return new ModelAndView("redirect:/content/viewall"); // Redirect to view all content after saving
    }

    
// ADMIN AND TEACHER
    
    
    
    
 // 1.5 - View all contents (previously /manage)    
    @RequestMapping("/manage")
    public ModelAndView manageAllContent() {
        List<Content> contents = contentService.getAllContent();
        ModelAndView modelAndView = new ModelAndView("content/manageall"); // View name
        modelAndView.addObject("contents", contents);
        return modelAndView;
    }

    
 // 5 - Update existing content (GET form)    
    @RequestMapping("/update/{contentID}")
    public ModelAndView showUpdateForm(@PathVariable String contentID) {
        Content content = contentService.getContentById(contentID);  // Fetch content by ID
        ModelAndView modelAndView = new ModelAndView("content/update"); // View name for the update form
        modelAndView.addObject("content", content);  // Add content object to model
        return modelAndView;
    }

    // 6 - Handle update content (POST form)
    @RequestMapping("/update/save")
    public ModelAndView updateContent(Content content) {
        contentService.updateContent(content);  // Call service to update content
        return new ModelAndView("redirect:/content/viewall");  // Redirect to view all content after saving
    }
    
    // 7 - Delete content
    @RequestMapping("/delete/{contentID}")
    public ModelAndView deleteContent(@PathVariable String contentID) {
        contentService.deleteContentById(contentID);
        return new ModelAndView("redirect:/content/viewall"); // Redirect to view all content after deletion
    }
}
