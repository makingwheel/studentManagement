package com.makingwheel.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.makingwheel.common.BeanUtils;
import com.makingwheel.controller.queryParams.CourseQueryParams;
import com.makingwheel.dao.BasicDao;
import com.makingwheel.dao.CourseDao;
import com.makingwheel.dao.entity.Course;
import com.makingwheel.model.vo.CourseVo;

@Repository
public class CourseDaoImpl extends BasicDao<Course>implements CourseDao {

	@Override
	public List<CourseVo> queryForStudent(CourseQueryParams queryParameters) {
		List<CourseVo> courseVos = new ArrayList<>();
		StringBuffer sql = new StringBuffer();
		sql.append("select c.id, c.name courseName, c.message, ")
				.append("t.name teacherName, ttc.week, ttc.node, ttc.begin_week, ")
				.append("ttc.end_week, ttc.place , stc.result ").append("from sm_course c, ")
				.append("sm_teacher_course tc, ").append("sm_teacher t, ").append("sm_time_teacher_course ttc, ")
				.append("sm_student_teacher_course stc ").append("where c.id = tc.course_id ")
				.append("and tc.teacher_id = t.id ").append("and ttc.teacher_course_id = tc.id ")
				.append("and stc.teacher_course_id = tc.id ").append("and tc.term_id = ? ")
				.append("and stc.student_id = ? ");
		SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
		sqlQuery.setFirstResult(queryParameters.getFirstResult());
		sqlQuery.setMaxResults(queryParameters.getLimit());
		sqlQuery.setParameter(0, queryParameters.getTermId());
		sqlQuery.setParameter(1, queryParameters.getStudentId());
		@SuppressWarnings("unchecked")
		List<Object[]> results = sqlQuery.list();
		for (Object[] result : results) {
			try {
				courseVos.add(BeanUtils.counstruct(result, CourseVo.class));
			} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return courseVos;
	}

	@Override
	public Integer queryCountForStudent(CourseQueryParams queryParameters) {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) ").append("from sm_course c, ").append("sm_teacher_course tc, ")
				.append("sm_teacher t, ").append("sm_time_teacher_course ttc, ")
				.append("sm_student_teacher_course stc ").append("where c.id = tc.course_id ")
				.append("and tc.teacher_id = t.id ").append("and ttc.teacher_course_id = tc.id ")
				.append("and stc.teacher_course_id = tc.id ").append("and tc.term_id = ? ")
				.append("and stc.student_id = ? ");
		SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
		sqlQuery.setParameter(0, queryParameters.getTermId());
		sqlQuery.setParameter(1, queryParameters.getStudentId());
		BigInteger count = (BigInteger) sqlQuery.uniqueResult();
		return count.intValue();
	}

	@Override
	public List<CourseVo> queryForTeacher(CourseQueryParams queryParameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer queryCountForTeacher(CourseQueryParams queryParameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> queryForManager(CourseQueryParams queryParameters) {
		StringBuffer hql = new StringBuffer("from Course ");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		query.setFirstResult(queryParameters.getFirstResult());
		query.setMaxResults(queryParameters.getLimit());
		@SuppressWarnings("unchecked")
		List<Course> courses = query.list();
		return courses;
	}

	@Override
	public int queryCountForManager(CourseQueryParams queryParameters) {
		StringBuffer hql = new StringBuffer("select count(*) from Course c ");
		Long total = (Long) sessionFactory.getCurrentSession().createQuery(hql.toString()).uniqueResult();
		return total.intValue();
	}

}
