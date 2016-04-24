package com.makingwheel.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.makingwheel.model.impl.StudentServiceImpl;

@Controller
@RequestMapping(value = "/student/bisicMessage/")
public class BasicMessage {

	private static final String BISIC_PATH = "";
	
	//@Autowired
	//private StudentServiceImpl studentServiceImpl;
	
	
	/*@RequestMapping(value = "")
	public ModelAndView index(ModelMap model, Long id){
		
	}*/
}
