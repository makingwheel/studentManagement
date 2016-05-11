package com.makingwheel.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.makingwheel.controller.sign.UserVo;
import com.makingwheel.dao.entity.Student;
import com.makingwheel.model.StudentService;

@Controller
@RequestMapping(value = "/student/basicMessage/")
@SessionAttributes("user")
public class BasicMessageController {

	private static final String BASIC_PATH = "/student/basicMessage/";

	@Autowired
	private StudentService studentServiceImpl;

	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model, @ModelAttribute(value = "user") UserVo user) {
		model.put("student", studentServiceImpl.findByCount(user.getCount()).orElse(new Student()));
		return new ModelAndView(BASIC_PATH + "index", model);
	}
}
