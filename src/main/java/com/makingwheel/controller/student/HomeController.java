package com.makingwheel.controller.student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.makingwheel.common.PageResult;
import com.makingwheel.dao.entity.Notice;
import com.makingwheel.model.NoticeService;

@Controller
@RequestMapping(value = "/student/home")
public class HomeController {

	private static final String BASIC_PATH = "/student/home";
	
	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model) {
		return new ModelAndView(BASIC_PATH + "/index", model);
	}

	@ResponseBody
	@RequestMapping(value = "list.do", method=RequestMethod.GET)
	public PageResult list(ModelMap model)
	{
		PageResult pageResult = new PageResult();
		
		List<Notice> notices =new ArrayList<>();
		Notice notice = new Notice();
		notice.setTitle("aaaaa");
		notice.setMessage("bbbbbbbbbb");
		notice.setModifyDate(new Date());
		notices.add(notice);
		
		Notice notice1 = new Notice();
		notice1.setTitle("aew");
		notice1.setMessage("bbbwebbbbbb");
		notices.add(notice1);
		
		Notice notice2 = new Notice();
		notice2.setTitle("asdaa");
		notice2.setMessage("bbfebbbb");
		notices.add(notice2);
		
		Notice notice3 = new Notice();
		notice3.setTitle("artaa");
		notice3.setMessage("bbjuubbbb");
		notices.add(notice3);
		pageResult.setRows(noticeService.queryByStatus(1));
		return pageResult;
	}
}
