package com.grg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/test")
public class TestController {

	@RequestMapping(value = "test.do" , method = RequestMethod.GET)
	public ModelAndView test(ModelMap model){
		return new ModelAndView("/test" , model);
	}
}
