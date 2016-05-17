package com.makingwheel.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.makingwheel.common.PageResult;
import com.makingwheel.controller.queryParams.CourseQueryParameters;
import com.makingwheel.model.CourseService;

@Controller
@RequestMapping(value = "/student/timetable/")
public class TimetableController {
	private static final String BASIC_PATH = "/student/timetable/";
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model){
		return new ModelAndView(BASIC_PATH + "index" , model);
	}
	
	@ResponseBody
	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public PageResult list(ModelMap model, CourseQueryParameters queryParameters){
		return courseService.queryForStudent(queryParameters);
	}
}
