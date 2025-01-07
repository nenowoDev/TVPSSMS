package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Content;
import com.example.service.ContentService;
import java.util.List;

@Controller
@RequestMapping("/content")
public class ContentController {

    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    // View the home page
    @RequestMapping("/home")
    public ModelAndView viewHome() {
        ModelAndView mav = new ModelAndView("content/home");
        return mav;
    }

    // View all content
    @RequestMapping("/view")
    public ModelAndView viewContent() {
        ModelAndView mav = new ModelAndView("content/view");
        
        // Get list of content from service
        List<Content> contentList = contentService.getAllContent();

        // Add the list to the model
        mav.addObject("contentList", contentList);
        return mav;
    }

    // View a single content item by ID
    @RequestMapping("/view/{contentID}")
    public ModelAndView viewContent(@PathVariable("contentID") String contentID) {
        ModelAndView mav = new ModelAndView("content/viewContent");

        // Get content details from the service
        Content content = contentService.getContentById(contentID);

        // Add the content to the model
        mav.addObject("content", content);
        return mav;
    }

    // View analytics for a specific content item
    @RequestMapping("/analytics/{contentID}")
    public ModelAndView viewAnalytics(@PathVariable("contentID") String contentID) {
        ModelAndView mav = new ModelAndView("content/analytics");

        // Get content details from the service
        Content content = contentService.getContentById(contentID);

        // Add the content and analytics to the model
        mav.addObject("content", content);

        // For demo purposes, we can add the analytics here
        mav.addObject("analytics", "Analytics data for content " + contentID);

        return mav;
    }
}
