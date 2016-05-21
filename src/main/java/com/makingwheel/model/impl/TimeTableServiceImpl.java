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
import com.makingwheel.dao.impl.SMClassDaoImpl;
import com.makingwheel.dao.impl.TimeTableDaoImpl;
import com.makingwheel.model.TimeTableService;
import com.makingwheel.model.vo.TimeTableListVo;

@Service
public class TimeTableServiceImpl implements TimeTableService {

	@Autowired
	private TimeTableDaoImpl timeTableDaoImpl;
	
	@Autowired
	private SMClassDaoImpl smClassDaoImpl;

	@Override
	public PageResult list(TimeTableQueryParams queryParams) {
		PageResult pageResult = new PageResult();
		List<TimeTableListVo> timeTableListVos = new ArrayList<>();
		for (Object[] objects : timeTableDaoImpl.list(queryParams)) {
			try {
				timeTableListVos.add(BeanUtils.counstruct(objects, TimeTableListVo.class));
			} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		timeTableListVos.stream().forEach(x ->{
			Long classId = x.getClassId();
			if (null != classId) {
				smClassDaoImpl.find(classId).ifPresent(smClass ->{
					org.springframework.beans.BeanUtils.copyProperties(smClass, x);
				});
			}
		});
		pageResult.setRows(timeTableListVos);
		pageResult.setTotal(timeTableDaoImpl.queryListCount(queryParams));
		return pageResult;
	}

	@Override
	public Optional<TimeTableListVo> findByTimeTeacherCourseId(Long timeTeacherCourseId) {
		TimeTableListVo timeTableListVo = null;
		Long classId = null;
		try {
			timeTableListVo = BeanUtils.counstruct(
					(Object[]) timeTableDaoImpl.findByTimeTeacherCourseId(timeTeacherCourseId), TimeTableListVo.class);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null != timeTableListVo && (null != (classId = timeTableListVo.getClassId()))) {
			org.springframework.beans.BeanUtils.copyProperties(smClassDaoImpl.find(classId), timeTableListVo);
		}
		return Optional.ofNullable(timeTableListVo);
	}

	@Override
	public void saveOrUpdateTimeTeacherCourse(TimeTeacherCourse timeTeacherCourse) {
		timeTableDaoImpl.saveOrUpdate(timeTeacherCourse);
	}

}
