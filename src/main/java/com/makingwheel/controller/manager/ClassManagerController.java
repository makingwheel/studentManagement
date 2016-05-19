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
import com.makingwheel.dao.entity.SMClass;
import com.makingwheel.model.SMClassService;

@Controller
@RequestMapping(value = "/manager/class/")
public class ClassManagerController {

	private final static String BASIC_PATH = "/manager/class/";
	private final static String SUCCESS = "success";
	@Autowired
	private SMClassService classService;

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
	public PageResult list(ModelMap model, QueryParameters queryParams) {
		return classService.list(queryParams);
	}

	@RequestMapping(value = "saveOrUpdate.do", method = RequestMethod.GET)
	public ModelAndView saveOrUpdate(ModelMap model, Long classId) {
		model.put("class", classId != null ? classService.find(classId).orElse(new SMClass()) : new SMClass());
		return new ModelAndView(BASIC_PATH + "saveOrUpdate", model);
	}

	@ResponseBody
	@RequestMapping(value = "saveOrUpdate.do", method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(ModelMap model, SMClass smClass) {
		classService.saveOrUpdate(smClass);
		model.put(SUCCESS, true);
		return new ModelAndView(new MappingJackson2JsonView(), model);
	}
}
