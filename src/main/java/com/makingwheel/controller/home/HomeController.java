package com.makingwheel.controller.home;

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
import com.makingwheel.common.QueryParameters;
import com.makingwheel.model.NoticeService;
import com.makingwheel.model.vo.UserVo;

@Controller
@RequestMapping(value = "/home")
@SessionAttributes("user")
public class HomeController {

	private static final String BASIC_PATH = "/home";

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model) {
		return new ModelAndView(BASIC_PATH + "/index", model);
	}

	@ResponseBody
	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public PageResult list(ModelMap model, @ModelAttribute(value = "user") UserVo user,
			QueryParameters queryParameters) {
		if (0 == user.getType()) {
			return noticeService.list(queryParameters);
		}
		return noticeService.queryByStatus(1, queryParameters);
	}
}
