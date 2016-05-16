package com.makingwheel.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.makingwheel.common.BeanUtils;
import com.makingwheel.controller.queryParams.CourseQueryParameters;
import com.makingwheel.dao.BasicDao;
import com.makingwheel.dao.CourseDao;
import com.makingwheel.dao.entity.Course;
import com.makingwheel.model.vo.CourseVo;

@Repository
public class CourseDaoImpl extends BasicDao<Course>implements CourseDao {

	@Override
	public List<CourseVo> querybyTerm(CourseQueryParameters queryParameters) {
		List<CourseVo> courseVos = new ArrayList<>();
		StringBuffer sql = new StringBuffer();
		sql.append("select c.id , c.name ")
		.append("from sm_course c, ")
		.append("sm_teacher_course tc ")
		.append("where c.id = tc.course_id ");
		SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
		sqlQuery.setFirstResult(queryParameters.getFirstResult());
		sqlQuery.setMaxResults(queryParameters.getLimit());
		@SuppressWarnings("unchecked")
		List<Object[]> results = sqlQuery.list();
		for(Object[] result : results){
			try {
				courseVos.add(BeanUtils.counstruct(result, CourseVo.class));
			} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return courseVos;
	}

	@Override
	public Integer queryCountbyTerm(CourseQueryParameters queryParameters) {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) ")
		.append("from sm_course c, ")
		.append("sm_teacher_course tc ")
		.append("where c.id = tc.course_id ");
		SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
		BigInteger count = (BigInteger) sqlQuery.uniqueResult();
		return count.intValue();
	}

}
