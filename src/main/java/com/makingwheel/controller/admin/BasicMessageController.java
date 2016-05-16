//package com.makingwheel.controller.admin;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.makingwheel.model.vo.UserVo;
//
//@Controller
//@RequestMapping(value = "/admin/basicMessage/")
//@SessionAttributes("user")
//public class BasicMessageController {
//
//	private static final String BASIC_PATH = "/admin/basicMessage/";
//
//	//@Autowired
////	private teacherService teacherServiceImpl;
//
//	@RequestMapping(value = "index.do", method = RequestMethod.GET)
//	public ModelAndView index(ModelMap model, @ModelAttribute(value = "user") UserVo user) {
//		//model.put("teacher", teacherServiceImpl.findByCount(user.getCount()).orElse(new teacher()));
//		return new ModelAndView(BASIC_PATH + "index", model);
//	}
//}
