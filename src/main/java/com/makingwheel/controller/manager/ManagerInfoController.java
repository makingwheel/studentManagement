package com.makingwheel.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.makingwheel.dao.entity.Manager;
import com.makingwheel.model.ManagerService;
import com.makingwheel.model.vo.UserVo;

@Controller
@RequestMapping(value = "/manager/info/")
@SessionAttributes("user")
public class ManagerInfoController {

	private static final String BASIC_PATH = "/manager/info/";

	@Autowired
	private ManagerService managerServiceImpl;

	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model, @ModelAttribute(value = "user") UserVo user) {
		model.put("manager", managerServiceImpl.findByCount(user.getCount()).orElse(new Manager()));
		return new ModelAndView(BASIC_PATH + "index", model);
	}
}
