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
@RequestMapping("/program")
public class ProgramController {

	@RequestMapping("/view")
	public ModelAndView viewContent(){
		ModelAndView mav=new ModelAndView("program/view");
		
		return mav;}
		

		
		@RequestMapping("/add")
		public ModelAndView addProgram(){
			ModelAndView mav=new ModelAndView("program/add");
			return mav;
		
		
	}
	
	
	
}

