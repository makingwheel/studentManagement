package com.makingwheel.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.makingwheel.common.QueryParameters;
import com.makingwheel.dao.BasicDao;
import com.makingwheel.dao.NoticeDao;
import com.makingwheel.dao.entity.Notice;

@Repository
public class NoticeDaoImpl extends BasicDao<Notice>implements NoticeDao {

	@Override
	public List<Notice> queryByStatus(Integer status, QueryParameters queryParameters) {
		StringBuffer hql = new StringBuffer("from Notice n ");
		hql.append("where n.status = ? ");
		hql.append("order by n.modifyDate desc ");
		@SuppressWarnings("unchecked")
		List<Notice> list = (List<Notice>) hibernateTemplate.execute(session -> {
			Query query = session.createQuery(hql.toString());
			query.setMaxResults(queryParameters.getLimit());
			query.setFirstResult(queryParameters.getFirstResult());
			query.setParameter(0, status);
			return query.list();
		});
		return list;
	}

	@Override
	public Integer queryCountByStatus(Integer status) {
		StringBuffer hql = new StringBuffer("select count(*) ");
		hql.append("from Notice n ");
		hql.append("where n.status = ? ");
		Long count = (Long) hibernateTemplate.find(hql.toString(), status).listIterator().next();
		return count.intValue();
	}

	@Override
	public List<Notice> query(QueryParameters queryParameters) {
		StringBuffer hql = new StringBuffer("from Notice n ");
		hql.append("order by n.modifyDate desc ");
		@SuppressWarnings("unchecked")
		List<Notice> list = (List<Notice>) hibernateTemplate.execute(session -> {
			Query query = session.createQuery(hql.toString());
			query.setMaxResults(queryParameters.getLimit());
			query.setFirstResult(queryParameters.getFirstResult());
			return query.list();
		});
		return list;
	}
	@Override
	public Integer queryCount() {
		StringBuffer hql = new StringBuffer("select count(*) ");
		hql.append("from Notice n ");
		Long count = (Long) hibernateTemplate.find(hql.toString()).listIterator().next();
		return count.intValue();
	}
}
