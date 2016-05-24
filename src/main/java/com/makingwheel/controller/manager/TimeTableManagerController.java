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
import com.makingwheel.controller.queryParams.TimeTableQueryParams;
import com.makingwheel.dao.entity.SMClass;
import com.makingwheel.dao.entity.TimeTeacherCourse;
import com.makingwheel.model.SMClassService;
import com.makingwheel.model.TimeTableService;
import com.makingwheel.model.vo.TimeTableListVo;

@Controller
@RequestMapping(value = "/manager/timeTable/")
public class TimeTableManagerController {

	private final static String BASIC_PATH = "/manager/timeTable/";
	private final static String SUCCESS = "success";

	@Autowired
	private TimeTableService timeTableService;

	@Autowired
	private SMClassService smClassService;

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
	public PageResult list(ModelMap model, TimeTableQueryParams queryParams) {
		return timeTableService.list(queryParams);
	}

	@RequestMapping(value = "saveOrUpdate.do", method = RequestMethod.GET)
	public ModelAndView saveOrUpdate(ModelMap model, Long timeTeacherCourseId) {
		TimeTableListVo timeTableListVo = timeTableService.findByTimeTeacherCourseId(timeTeacherCourseId)
				.orElse(new TimeTableListVo());
		Long smClassId = timeTableListVo.getClassId();
		if (null != smClassId) {
			model.put("smClass", smClassService.find(smClassId).orElse(new SMClass()));
		}else{
			model.put("smClasses", smClassService.findAll());
		}
		model.put("timeTable", timeTableListVo);
		return new ModelAndView(BASIC_PATH + "saveOrUpdate", model);
	}

	@ResponseBody
	@RequestMapping(value = "saveOrUpdate.do", method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(ModelMap model, TimeTeacherCourse timeTeacherCourse) {
		timeTableService.saveOrUpdateTimeTeacherCourse(timeTeacherCourse);
		model.put(SUCCESS, true);
		return new ModelAndView(new MappingJackson2JsonView(), model);
	}
}
