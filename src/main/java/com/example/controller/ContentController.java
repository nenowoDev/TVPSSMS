package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Content;

@Controller
@RequestMapping("/content")
public class ContentController {

	@RequestMapping("/home")
	public ModelAndView viewHome(){
		ModelAndView mav=new ModelAndView("content/home");
		
		return mav;
	}
	
	@RequestMapping("/view")
	public ModelAndView viewContent(){
		ModelAndView mav=new ModelAndView("content/view");
		
		 ArrayList<Content> contentList = new ArrayList<>();

        contentList.add(new Content("1", "Video Title 1", "Description of Video 1", "2024-01-01", "Video", "101", "https://example.com/video1"));
        contentList.add(new Content("2", "Video Title 2", "Description of Video 2", "2024-02-01", "Video", "102", "https://example.com/video2"));
        contentList.add(new Content("3", "Video Title 3", "Description of Video 3", "2024-03-01", "Video", "103", "https://example.com/video3"));
        contentList.add(new Content("4", "Video Title 4", "Description of Video 4", "2024-04-01", "Video", "104", "https://example.com/video4"));
        contentList.add(new Content("5", "Video Title 5", "Description of Video 5", "2024-05-01", "Video", "105", "https://example.com/video5"));
        
        
        mav.addObject("contentList",contentList);
		return mav;
	}
	
	@RequestMapping("/view/{contentID}")
	public ModelAndView viewContent(@PathVariable("contentID") String contentID){
		ModelAndView mav=new ModelAndView("content/viewContent");
		
		
		return mav;
	}
	
	
	
	
	@RequestMapping("/analytics/{contentID")
	public ModelAndView viewAnalytics(@PathVariable("contentID") String contentID){
		ModelAndView mav=new ModelAndView("content/analytics");
		
		Content test=new Content();
		test.setContentID(contentID);
		test.setContentDescription("This is a test video");
		test.setContentTitle("SPRM");
		test.setContentUploadDate(contentID);
		test.setLink("https://www.youtube.com/embed/HqapKozwaDg?si=lDXi4mBSSmbNcT0H");
		test.setProgramID("2");
		
		ArrayList<Content> contentList = new ArrayList<>();
		 contentList.add(new Content("1", "Video Title 1", "Description of Video 1", "2024-01-01", "Video", "101", "https://example.com/video1"));
        contentList.add(new Content("2", "Video Title 2", "Description of Video 2", "2024-02-01", "Video", "102", "https://example.com/video2"));
        contentList.add(new Content("3", "Video Title 3", "Description of Video 3", "2024-03-01", "Video", "103", "https://example.com/video3"));
        contentList.add(new Content("4", "Video Title 4", "Description of Video 4", "2024-04-01", "Video", "104", "https://example.com/video4"));
        contentList.add(new Content("5", "Video Title 5", "Description of Video 5", "2024-05-01", "Video", "105", "https://example.com/video5"));
	        
	        
        mav.addObject("contentList",contentList);

	        
	        
		mav.addObject("currentVideo",test);
		
		return mav;
	}
	
	
}

