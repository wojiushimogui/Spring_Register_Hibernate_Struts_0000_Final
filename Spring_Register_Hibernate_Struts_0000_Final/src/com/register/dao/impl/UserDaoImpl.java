package com.register.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.register.dao.UserDao;
import com.register.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao{
	
	private HibernateTemplate  hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(User user) {
		this.hibernateTemplate.save(user);
	}

	@Override
	public boolean exists(User user) {
//		SessionFactory sessionFactory=hibernateTemplate.getSessionFactory();
//		Session session=sessionFactory.getCurrentSession();
//		session.beginTransaction();
//		//利用hql来查询数据库中是否已经存在此名字的用户
//		String hql="from User as u where u.username=?";
//		Query query=session.createQuery(hql);
//		query.setString(0, user.getUsername());
//		List list=query.list();
//		if(!list.isEmpty()){
//			return true;
//		}
//		session.getTransaction().commit();
//		return false;
		List res=hibernateTemplate.find("from User as u where u.username=?", user.getUsername());
		if(res!=null&&res.size()>0){
			return true;
		}
		return false;
//		SessionFactory sessionFactory=hibernateTemplate.getSessionFactory();
//		Session session=sessionFactory.openSession();
//		session.beginTransaction();
//		//利用hql来查询数据库中是否已经存在此名字的用户
//		String hql="from User as u where u.username=?";
//		Query query=session.createQuery(hql);
//		query.setString(0, user.getUsername());
//		List list=query.list();
//		if(!list.isEmpty()){
//			return true;
//		}
//		session.getTransaction().commit();
//		session.close();
//		return false;
		
	}

}
