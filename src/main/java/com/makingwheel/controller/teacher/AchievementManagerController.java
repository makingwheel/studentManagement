package com.makingwheel.controller.teacher;

import java.util.Comparator;
import java.util.stream.Collectors;

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
import com.makingwheel.dao.entity.Term;
import com.makingwheel.model.CourseService;
import com.makingwheel.model.TeacherService;
import com.makingwheel.model.TermService;
import com.makingwheel.model.vo.UserVo;

@Controller
@RequestMapping(value = "/teacher/achievement/")
@SessionAttributes({ "user"})
public class AchievementManagerController {

	private static final String BASIC_PATH = "/teacher/achievement/";

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private TermService termService;

	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model) {
		model.put("terms", termService.findAll().stream().sorted(Comparator.comparing(Term::getId).reversed())
				.collect(Collectors.toList()));
		return new ModelAndView(BASIC_PATH + "index", model);
	}

	@ResponseBody
	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public PageResult list(ModelMap model,
			@ModelAttribute(value = "user") UserVo user, CourseQueryParams queryParameters) {
		teacherService.findByCount(user.getCount()).ifPresent(x->queryParameters.setTeacherId(x.getId()));
		return courseService.queryForTeacher(queryParameters);
	}
	
	@ResponseBody
	@RequestMapping(value= "updateResult.do", method = RequestMethod.POST)
	public ModelAndView updateResult(ModelMap model, Long studentTeacherCourseId, double result){
		courseService.updateResult(studentTeacherCourseId, result);
		return new  ModelAndView(new MappingJackson2JsonView() , model);
	}
}
