package com.makingwheel.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.makingwheel.common.PageResult;
import com.makingwheel.common.QueryParameters;
import com.makingwheel.model.NoticeService;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

	private static final String BASIC_PATH = "/home";
	
	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model) {
		return new ModelAndView(BASIC_PATH + "/index", model);
	}

	@ResponseBody
	@RequestMapping(value = "list.do", method=RequestMethod.GET)
	public PageResult list(ModelMap model, QueryParameters queryParameters)
	{
		return noticeService.queryByStatus(1, queryParameters);
	}
}