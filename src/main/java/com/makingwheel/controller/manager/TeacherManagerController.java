package com.makingwheel.controller.manager;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.makingwheel.common.PageResult;
import com.makingwheel.controller.queryParams.TeacherQueryParams;
import com.makingwheel.dao.entity.Teacher;
import com.makingwheel.model.TeacherService;

@Controller
@RequestMapping(value = "/manager/teacher/")
public class TeacherManagerController {

	private final static String BASIC_PATH = "/manager/teacher/";
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
	public ModelAndView index(ModelMap model) {
		return new ModelAndView(BASIC_PATH + "index", model);
	}

	@ResponseBody
	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public PageResult list(ModelMap model, TeacherQueryParams queryParams) {
		return teacherService.list(queryParams);
	}

	@RequestMapping(value = "saveOrUpdate.do", method = RequestMethod.GET)
	public ModelAndView saveOrUpdate(ModelMap model, Long teacherId) {
		model.put("teacher", teacherId != null ? teacherService.find(teacherId).orElse(new Teacher()) : new Teacher());
		return new ModelAndView(BASIC_PATH + "saveOrUpdate", model);
	}

	@ResponseBody
	@RequestMapping(value = "saveOrUpdate.do", method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(ModelMap model, Teacher teacher) {
		teacherService.saveOrUpdate(teacher);
		model.put(SUCCESS, true);
		return new ModelAndView(new MappingJackson2JsonView(), model);
	}
}
