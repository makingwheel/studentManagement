package com.makingwheel.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.makingwheel.common.QueryParameters;

public class BasicDao<T> {
	
	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public BasicDao() {
		ParameterizedType parameterizedType = 
				(ParameterizedType)this.getClass().getGenericSuperclass(); 
		entityClass = (Class<T>)(parameterizedType.getActualTypeArguments()[0]); 
	}

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public T save(T t){
		hibernateTemplate.save(t);
		return t;
	}
	
	public T saveOrUpdate(T t){
		hibernateTemplate.saveOrUpdate(t);
		return t;
	}
	
	public T update(T t){
		hibernateTemplate.update(t);
		return t;
	}
	
	public T delete(T t){
		hibernateTemplate.delete(t);
		return t;
	}
	
	public Optional<T> find(Long id){
		return Optional.ofNullable(hibernateTemplate.get(entityClass, id));
	}
	
	public Optional<List<T>> findAll(){
		return Optional.ofNullable(hibernateTemplate.loadAll(entityClass));
	}
	
	public Optional<List<T>> queryPage(QueryParameters queryParameters)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(entityClass);
		criteria.setFirstResult(queryParameters.getFirstResult());
		criteria.setMaxResults(queryParameters.getLimit());
		@SuppressWarnings("unchecked")
		List<T> list = criteria.list();
		return Optional.ofNullable(list);
	}
	
	@SuppressWarnings("unchecked")
	public Optional<List<T>> queryPage(final QueryParameters queryParameters , final String hql , final Object... values) {
		return Optional.ofNullable(
				hibernateTemplate.execute(session ->{
					Query query = session.createQuery(hql);
					query.setParameter(0, values);
					if (values != null) {
						for (int i = 0, length = values.length; i < length; i++) {
							query.setParameter(i, values[i]);
						}
					}
					query.setFirstResult(queryParameters.getFirstResult());
					query.setMaxResults(queryParameters.getLimit());
					return query.list();
				})
		);
	}
	
	public Optional<List<?>> query(String hql , Object... values){
		return Optional.ofNullable(hibernateTemplate.find(hql, values));
	}
}
