package com.makingwheel.controller.sign;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/sign/")
public class SignController {
	
	private static final String BASIC_PATH = "/sign/";
	
	@RequestMapping(value = "on.do" , method = RequestMethod.GET)
	public ModelAndView signOn(ModelMap model) {
		return new ModelAndView(BASIC_PATH + "index", model);
	}

}
