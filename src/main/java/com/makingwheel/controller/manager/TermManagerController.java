package com.makingwheel.controller.manager;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.makingwheel.common.PageResult;
import com.makingwheel.common.QueryParameters;
import com.makingwheel.dao.entity.Term;
import com.makingwheel.model.TermService;

@Controller
@RequestMapping(value = "/manager/term/")
public class TermManagerController {

	private final static String BASIC_PATH = "/manager/term/";
	private final static String SUCCESS = "success";
	@Autowired
	private TermService termService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// true:允许输入空值，false:不能为空值
	}

	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model) {
		return new ModelAndView(BASIC_PATH + "index", model);
	}

	@ResponseBody
	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public PageResult list(ModelMap model,QueryParameters queryParams) {
		return termService.list(queryParams);
	}

	@RequestMapping(value = "saveOrUpdate.do", method = RequestMethod.GET)
	public ModelAndView saveOrUpdate(ModelMap model, Long termId) {
		model.put("term", termId != null ? termService.find(termId).orElse(new Term()) : new Term());
		return new ModelAndView(BASIC_PATH + "saveOrUpdate", model);
	}

	@ResponseBody
	@RequestMapping(value = "saveOrUpdate.do", method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(ModelMap model, Term term) {
		termService.saveOrUpdate(term);
		model.put(SUCCESS, true);
		return new ModelAndView(new MappingJackson2JsonView(), model);
	}
}
