package com.makingwheel.model;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.makingwheel.common.SpringUtils;
import com.makingwheel.dao.entity.Notice;

public interface NoticeService {

	public HibernateTemplate hibernateTemplate = (HibernateTemplate) SpringUtils.getBean(HibernateTemplate.class);

	public List<Notice> queryByStatus(Integer status);
}
