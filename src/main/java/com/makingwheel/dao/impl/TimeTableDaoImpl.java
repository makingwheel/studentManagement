package com.makingwheel.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.makingwheel.controller.queryParams.TimeTableQueryParams;
import com.makingwheel.dao.BasicDao;
import com.makingwheel.dao.TimeTableDao;
import com.makingwheel.dao.entity.TimeTeacherCourse;

@Repository
public class TimeTableDaoImpl extends BasicDao<TimeTeacherCourse>implements TimeTableDao {

	@Override
	public List<Object[]> list(TimeTableQueryParams queryParams) {
		StringBuffer sql = new StringBuffer("select ttc.id ttc_id, tc.id tc_id, ");
		sql.append("c.name course_name, c.message, ");
		sql.append("t.name teacher_name, ttc.week, ttc.node, ttc.begin_week, ");
		sql.append("ttc.end_week, ttc.place, ttc.class_id class_id ");
		sql.append("from sm_teacher t, ");
		sql.append("sm_teacher_course tc, ");
		sql.append("sm_course c, ");
		sql.append("sm_time_teacher_course ttc, ");
		sql.append("sm_term term ");
		sql.append("where tc.teacher_id = t.id ");
		sql.append("and tc.course_id = c.id ");
		sql.append("and tc.term_id = term.id ");
		sql.append("and ttc.teacher_course_id = tc.id ");
		;
		SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
		sqlQuery.setFirstResult(queryParams.getFirstResult());
		sqlQuery.setMaxResults(queryParams.getLimit());
		@SuppressWarnings("unchecked")
		List<Object[]> list = sqlQuery.list();
		return list;
	}

	@Override
	public int queryListCount(TimeTableQueryParams queryParams) {
		StringBuffer sql = new StringBuffer("select count(*) ");
		sql.append("from sm_teacher t, ")
		.append("sm_teacher_course tc, ")
		.append("sm_course c, ")
		.append("sm_time_teacher_course ttc, ")
		.append("sm_term term ")
		.append("where tc.teacher_id = t.id ")
		.append("and tc.course_id = c.id ")
		.append("and tc.term_id = term.id ")
		.append("and ttc.teacher_course_id = tc.id ")
		;
		BigInteger total = (BigInteger) sessionFactory.getCurrentSession().createSQLQuery(sql.toString()).uniqueResult();
		return total.intValue();
	}

	@Override
	public Object findByTimeTeacherCourseId(Long timeTeacherCourseId) {
		StringBuffer sql = new StringBuffer("select ttc.id ttc_id, tc.id tc_id, ");
		sql.append("c.name course_name, c.message, ")
		.append("t.name teacher_name, ttc.week, ttc.node, ttc.begin_week, ")
		.append("ttc.end_week, ttc.place, ttc.class_id class_id ")
		.append("from sm_teacher t, ")
		.append("sm_teacher_course tc, ")
		.append("sm_course c, ")
		.append("sm_time_teacher_course ttc, ")
		.append("sm_term term ")
		.append("where tc.teacher_id = t.id ")
		.append("and tc.course_id = c.id ")
		.append("and tc.term_id = term.id ")
		.append("and ttc.teacher_course_id = tc.id ")
		.append("and ttc.id = ? ")
		;
		SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
		sqlQuery.setParameter(0, timeTeacherCourseId);
		return sqlQuery.uniqueResult();
	}
}
