package com.scut.victor.dao.impl;

import com.scut.victor.dao.UserDao;
import com.scut.victor.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public User get(String id) {
		return (User)this.getSession().get(User.class, id);
	}

	@Override
	public String save(User entity) {
		User user = getUserByUserId(entity.getUserId());
		if (user != null)
			return null;
		return (String)this.getSession().save(entity);
	}

	@Override
	public void delete(String id) {
		User entity = this.load(id);
		this.getSession().delete(entity);		
	}

	@Override
	public User load(String id) {
		return (User)this.getSession().load(User.class, id);
	}

	@Override
	public List<User> findAll() {
		List<User> users = this.getSession().createQuery("from User").list();
		return users;
	}

	@Override
	public void persist(User entity) {
		
	}

	@Override
	public void saveOrUpdate(User entity) {
		this.getSession().clear(); //important
		this.getSession().saveOrUpdate(entity);
	}

	@Override
	public void flush() {
		
	}

	@Override
	public User getUserByUserId(String userId) {
        String hql = "from User where userId = ?";
        Query query = this.getSession().createQuery(hql);
        query.setString(0, userId);
		return (User) query.uniqueResult();
	}

	@Override
	public User getUserById(String id) {
		String hql = "from User where id = ?";
		Query query = this.getSession().createQuery(hql);
		query.setString(0, id);
		return (User) query.uniqueResult();
	}
}
