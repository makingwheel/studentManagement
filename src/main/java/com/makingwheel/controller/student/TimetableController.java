package com.makingwheel.controller.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/student/timetable/")
public class TimetableController {
	private static final String BASIC_PATH = "/student/timetable/";
	
	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model){
		return new ModelAndView(BASIC_PATH + "index" , model);
	}
}
