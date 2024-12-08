package com.example.controller;

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

@Controller
@RequestMapping("/content")
public class ContentController {

	@RequestMapping("/home")
	public ModelAndView viewHome(){
		ModelAndView mav=new ModelAndView("content/home");
		
		return mav;
	}
	
	@RequestMapping()
	public ModelAndView viewContent(){
		ModelAndView mav=new ModelAndView("content/view");
		
		
		return mav;
	}
	
	
	@RequestMapping()
	public ModelAndView viewAnalytics(){
		ModelAndView mav=new ModelAndView("content/analytics");
		
		
		return mav;
	}
	
	
}

