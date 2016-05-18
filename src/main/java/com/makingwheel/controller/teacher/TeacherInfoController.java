package com.makingwheel.controller.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.makingwheel.dao.entity.Teacher;
import com.makingwheel.model.TeacherService;
import com.makingwheel.model.vo.UserVo;

@Controller
@RequestMapping(value = "/teacher/info/")
@SessionAttributes("user")
public class TeacherInfoController {

	private static final String BASIC_PATH = "/teacher/info/";

	@Autowired
	private TeacherService teacherServiceImpl;

	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model, @ModelAttribute(value = "user") UserVo user) {
		model.put("teacher", teacherServiceImpl.findByCount(user.getCount()).orElse(new Teacher()));
		return new ModelAndView(BASIC_PATH + "index", model);
	}
}
