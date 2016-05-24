package com.makingwheel.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.makingwheel.common.PageResult;
import com.makingwheel.controller.queryParams.CourseQueryParams;
import com.makingwheel.model.CourseService;
import com.makingwheel.model.StudentService;
import com.makingwheel.model.TermService;
import com.makingwheel.model.vo.UserVo;

@Controller
@RequestMapping(value = "/student/timetable/")
@SessionAttributes({ "user" })
public class TimetableController {
	private static final String BASIC_PATH = "/student/timetable/";

	@Autowired
	private CourseService courseService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private TermService termService;

	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model, @ModelAttribute(value = "user") UserVo user) {
		studentService.findByCount(user.getCount())
				.ifPresent(x -> model.put("terms", termService.findTremForStudent(x.getId())));
		return new ModelAndView(BASIC_PATH + "index", model);
	}

	@ResponseBody
	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public PageResult list(ModelMap model, @ModelAttribute(value = "user") UserVo user,
			CourseQueryParams queryParameters) {
		studentService.findByCount(user.getCount()).ifPresent(x -> queryParameters.setStudentId(x.getId()));
		return courseService.queryForStudent(queryParameters);
	}
}
