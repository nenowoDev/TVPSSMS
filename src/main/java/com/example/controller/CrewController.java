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
@RequestMapping("/crew")
public class CrewController {

	@RequestMapping("/registration")
	public ModelAndView viewRegistration(){
	    ModelAndView mav = new ModelAndView("crew/registration");
	    mav.addObject("attributeName", "value"); // Example attribute
	    return mav;
	}

	
	@RequestMapping("/task")
	public ModelAndView viewTask(){
		ModelAndView mav=new ModelAndView("crew/task");
		return mav;
	}
	
	
	
}
 
