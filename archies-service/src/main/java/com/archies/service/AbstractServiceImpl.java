package com.archies.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation=Propagation.REQUIRED, timeout=300)
public class AbstractServiceImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T getFirstResult(Query query, Class<T> resultType){
		List<T> resultList = (List<T>) query.list();
		if(resultList.size() > 0){
			return resultList.get(0);
		}
		return null;
	}
}
