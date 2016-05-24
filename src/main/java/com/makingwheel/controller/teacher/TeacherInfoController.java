package com.makingwheel.controller.teacher;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.makingwheel.dao.entity.Teacher;
import com.makingwheel.model.TeacherService;
import com.makingwheel.model.vo.UserVo;

@Controller
@RequestMapping(value = "/teacher/info/")
@SessionAttributes("user")
public class TeacherInfoController {

	private static final String BASIC_PATH = "/teacher/info/";
	private final static String SUCCESS = "success";

	@Autowired
	private TeacherService teacherService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// true:允许输入空值，false:不能为空值
	}
	
	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model, @ModelAttribute(value = "user") UserVo user) {
		model.put("teacher", teacherService.findByCount(user.getCount()).orElse(new Teacher()));
		return new ModelAndView(BASIC_PATH + "index", model);
	}

	@ResponseBody
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(ModelMap model, Teacher teacher) {
		teacherService.saveOrUpdate(teacher);
		model.put(SUCCESS, true);
		return new ModelAndView(new MappingJackson2JsonView(), model);
	}
}
