package com.makingwheel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.makingwheel.dao.entity.Student;
import com.makingwheel.model.StudentService;

@Controller
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	private StudentService studentServiceImpl;
	
	@RequestMapping(value = "/test.do" , method = RequestMethod.GET)
	public ModelAndView test(ModelMap model){
		return new ModelAndView("/test" , model);
	}
	
	@ResponseBody
	@RequestMapping(value = "/save.do" , method = RequestMethod.GET)
	public ModelAndView saveStudent(ModelMap model,Student student){
		studentServiceImpl.save(student);
		model.put("student", student.getName());
		return new ModelAndView(new MappingJackson2JsonView() , model);
	}
}
