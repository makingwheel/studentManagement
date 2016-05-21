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

import com.makingwheel.common.enums.NoticeStatus;
import com.makingwheel.dao.entity.Notice;
import com.makingwheel.model.NoticeService;

@Controller
@RequestMapping(value = "/manager/notice/")
public class NoticeManagerController {

	private final static String BASIC_PATH = "/manager/notice/";
	private final static String SUCCESS = "success";

	@Autowired
	private NoticeService noticeService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// true:允许输入空值，false:不能为空值
	}

	@RequestMapping(value = "saveOrUpdate.do", method = RequestMethod.GET)
	public ModelAndView saveOrUpdate(ModelMap model, Long noticeId) {
		model.put("notice", null != noticeId ? noticeService.find(noticeId).orElse(new Notice()) : new Notice());
		return new ModelAndView(BASIC_PATH + "saveOrUpdate", model);
	}

	@ResponseBody
	@RequestMapping(value = "saveOrUpdate.do", method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(ModelMap model, Notice notice) {
		notice.setModifyDate(new Date());
		notice.setStatus(NoticeStatus.USED.getValue());
		noticeService.saveOrUpdate(notice);
		model.put(SUCCESS, true);
		return new ModelAndView(new MappingJackson2JsonView(), model);
	}
	
	@ResponseBody
	@RequestMapping(value = "updateStatus.do", method = RequestMethod.POST)
	public ModelAndView updateStatus(ModelMap model, Long noticeId, int status) {
		noticeService.updateStatus(noticeId, status);
		model.put(SUCCESS, true);
		return new ModelAndView(new MappingJackson2JsonView(), model);
	}
}
