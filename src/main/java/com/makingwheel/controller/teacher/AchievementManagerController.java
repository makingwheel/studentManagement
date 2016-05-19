package com.makingwheel.controller.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.makingwheel.common.PageResult;
import com.makingwheel.controller.queryParams.CourseQueryParams;
import com.makingwheel.model.CourseService;
import com.makingwheel.model.StudentService;
import com.makingwheel.model.vo.UserVo;

@Controller
@RequestMapping(value = "/teacher/achievement/")
@SessionAttributes({ "user", "termId" })
public class AchievementManagerController {

	private static final String BASIC_PATH = "/teacher/achievement/";

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model) {
		return new ModelAndView(BASIC_PATH + "index", model);
	}

	@ResponseBody
	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public PageResult list(ModelMap model, @ModelAttribute(value = "termId") Long termId,
			@ModelAttribute(value = "user") UserVo user, CourseQueryParams queryParameters) {
		studentService.findByCount(user.getCount()).ifPresent(x -> queryParameters.setStudentId(x.getId()));
		queryParameters.setTermId(termId);
		return courseService.queryForStudent(queryParameters);
	}
	
	@ResponseBody
	@RequestMapping(value= "updateResult.do", method = RequestMethod.POST)
	public ModelAndView updateResult(ModelMap model){
		return new  ModelAndView(new MappingJackson2JsonView() , model);
	}
}
