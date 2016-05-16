//package com.makingwheel.controller.teacher;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.makingwheel.model.CourseService;
//import com.makingwheel.model.vo.CourseVo;
//
//@Controller
//@RequestMapping(value = "/teacher/timetable/")
//public class TimetableController {
//	private static final String BASIC_PATH = "/teacher/timetable/";
//	
//	@Autowired
//	private CourseService courseService;
//	
//	@RequestMapping(value = "index.do", method = RequestMethod.GET)
//	public ModelAndView index(ModelMap model){
//		return new ModelAndView(BASIC_PATH + "index" , model);
//	}
//	
//	@RequestMapping(value = "list.do", method = RequestMethod.GET)
//	public List<CourseVo> list(ModelMap model){
//		return courseService.querybyTerm(1L);
////		return new PageResult();
//	}
//}
