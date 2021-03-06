package com.makingwheel.controller.sign;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.makingwheel.model.SignService;
import com.makingwheel.model.TermService;
import com.makingwheel.model.vo.UserVo;

@Controller
@RequestMapping(value = "/sign/")
@SessionAttributes({"termId" })
public class SignController {

	private static final String BASIC_PATH = "/sign/";
	private static final String SUCCESS = "success";
	@Autowired
	private SignService signService;

	@Autowired
	private TermService termService;

	@RequestMapping(value = "on.op", method = RequestMethod.GET)
	public ModelAndView signOn(ModelMap model) {
		return new ModelAndView(BASIC_PATH + "index", model);
	}

	@ResponseBody
	@RequestMapping(value = "in.op", method = RequestMethod.POST)
	public ModelAndView signIn(ModelMap model, UserVo userVo, HttpServletRequest request) {
		if (signService.checkUser(userVo)) {
			signService.queryByUserVo(userVo).ifPresent(user -> userVo.setName(user.getName()));
			termService.queryCurrentTerm().ifPresent(x -> model.addAttribute("termId", x.getId()));
			userVo.setPassword("");
			request.getSession().setAttribute("user", userVo);
			model.put("user", userVo);
			model.put(SUCCESS, true);
		}
		return new ModelAndView(new MappingJackson2JsonView(), model);
	}

	@RequestMapping(value = "out.do", method = RequestMethod.GET)
	public ModelAndView signOut(ModelMap model, UserVo userVo, HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("termId");
		return new ModelAndView("redirect:on.op", model);
	}

}
