package com.makingwheel.controller.student;

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

import com.makingwheel.dao.entity.SMClass;
import com.makingwheel.dao.entity.Student;
import com.makingwheel.model.SMClassService;
import com.makingwheel.model.StudentService;
import com.makingwheel.model.vo.UserVo;

@Controller
@RequestMapping(value = "/student/basicMessage/")
@SessionAttributes("user")
public class BasicMessageController {

	private static final String BASIC_PATH = "/student/basicMessage/";
	private final static String SUCCESS = "success";
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SMClassService smClassService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// true:允许输入空值，false:不能为空值
	}

	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model, @ModelAttribute(value = "user") UserVo user) {
		Student student = studentService.findByCount(user.getCount()).orElse(new Student());
		model.put("smClass", smClassService.find(student.getClassId()).orElse(new SMClass()));
		model.put("student", student);
		return new ModelAndView(BASIC_PATH + "index", model);
	}
	
	@ResponseBody
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public ModelAndView update(ModelMap model, Student student) {
		studentService.saveOrUpdate(student);
		model.put(SUCCESS, true);
		return new ModelAndView(new MappingJackson2JsonView(), model);
	}
}
