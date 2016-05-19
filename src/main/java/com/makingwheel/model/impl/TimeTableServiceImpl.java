package com.makingwheel.model.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makingwheel.common.BeanUtils;
import com.makingwheel.common.PageResult;
import com.makingwheel.controller.queryParams.TimeTableQueryParams;
import com.makingwheel.dao.entity.TimeTeacherCourse;
import com.makingwheel.dao.impl.TimeTableDaoImpl;
import com.makingwheel.model.TimeTableService;
import com.makingwheel.model.vo.TimeTableListVo;

@Service
public class TimeTableServiceImpl implements TimeTableService {

	@Autowired
	private TimeTableDaoImpl timeTableDaoImpl;
	
	@Override
	public PageResult list(TimeTableQueryParams queryParams) {
		PageResult pageResult = new PageResult();
		List<TimeTableListVo> timeTableListVos = new ArrayList<>();
		for (Object[] objects : timeTableDaoImpl.list(queryParams)) {
			try {
				timeTableListVos.add(BeanUtils.counstruct(objects, TimeTableListVo.class));
			} catch (NoSuchMethodException | SecurityException
					| InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		pageResult.setRows(timeTableListVos);
		return pageResult;
	}

	@Override
	public Optional<TimeTableListVo> findByTimeTeacherCourseId( Long timeTeacherCourseId) {
		TimeTableListVo timeTableListVo = null;
		try {
			timeTableListVo = BeanUtils.counstruct((Object[])timeTableDaoImpl.findByTimeTeacherCourseId(timeTeacherCourseId),TimeTableListVo.class);
		} catch (NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.ofNullable(timeTableListVo);
	}

	@Override
	public void saveTimeTeacherCourse(TimeTeacherCourse timeTeacherCourse) {
		timeTableDaoImpl.save(timeTeacherCourse);
	}

}
