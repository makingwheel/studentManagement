package com.makingwheel.controller.teacher;

import javax.servlet.http.HttpServletRequest;

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
import com.makingwheel.dao.entity.TeacherCourse;
import com.makingwheel.dao.entity.TimeTeacherCourse;
import com.makingwheel.model.CourseService;
import com.makingwheel.model.TeacherCourseService;
import com.makingwheel.model.TeacherService;
import com.makingwheel.model.TimeTableService;
import com.makingwheel.model.vo.UserVo;

@Controller
@RequestMapping(value = "/teacher/course/")
@SessionAttributes({ "user" })
public class CourseController {
	private static final String BASIC_PATH = "/teacher/course/";

	@Autowired
	private CourseService courseService;

	@Autowired
	private TeacherCourseService teacherCourseService;

	@Autowired
	private TimeTableService timeTableService;

	@Autowired
	private TeacherService teacherService;

	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model) {
		return new ModelAndView(BASIC_PATH + "index", model);
	}

	@ResponseBody
	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public PageResult list(ModelMap model, HttpServletRequest request, Long termId,
			@ModelAttribute(value = "user") UserVo user, CourseQueryParams queryParameters) {
		teacherService.findByCount(user.getCount()).ifPresent(x -> queryParameters.setTeacherId(x.getId()));
		queryParameters.setTermId(null != termId ? termId : (Long) request.getSession().getAttribute("termId"));
		return courseService.queryForTeacher(queryParameters);
	}

	@RequestMapping(value = "save.do", method = RequestMethod.GET)
	public ModelAndView save(ModelMap model) {

		// TODO get term list
		// TODO get course list
		return new ModelAndView(BASIC_PATH + "save", model);
	}

	@ResponseBody
	@RequestMapping(value = "save.do", method = RequestMethod.POST)
	public ModelAndView save(ModelMap model, TeacherCourse teacherCourse) {
		teacherCourseService.save(teacherCourse);
		TimeTeacherCourse timeTeacherCourse = new TimeTeacherCourse();
		timeTeacherCourse.setTeacherCourseId(timeTeacherCourse.getId());
		timeTableService.saveOrUpdateTimeTeacherCourse(timeTeacherCourse);
		return new ModelAndView(new MappingJackson2JsonView(), model);
	}
}
