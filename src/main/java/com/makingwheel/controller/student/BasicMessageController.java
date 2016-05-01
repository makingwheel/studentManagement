package com.makingwheel.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.makingwheel.dao.entity.Student;
import com.makingwheel.model.StudentService;

@Controller
@RequestMapping(value = "/student/basicMessage/")
public class BasicMessageController {

	private static final String BASIC_PATH = "/student/basicMessage/";
	
	@Autowired
	private StudentService studentServiceImpl;
	
	
	@RequestMapping(value = "index.do", method = RequestMethod.GET)
//	public ModelAndView index(ModelMap model, Long id){
	public ModelAndView index(ModelMap model){
		Long id = 1L;
		model.put("student", studentServiceImpl.find(id).orElse(new Student()));
		return new ModelAndView(BASIC_PATH + "index", model);
	}
}