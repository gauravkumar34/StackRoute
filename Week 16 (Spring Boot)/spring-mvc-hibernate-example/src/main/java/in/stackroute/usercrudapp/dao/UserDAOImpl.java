package in.stackroute.usercrudapp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.stackroute.usercrudapp.model.User;

@Component
@Transactional
public class UserDAOImpl implements UserDAO {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public boolean addUser(User user) {
		user.setCreationDate(new Date());
		sessionFactory.getCurrentSession().save(user);
		return true;
		
	}
	
	@Override
	public boolean updateUser(User user) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
		
	}

	@Override
	public boolean deleteUser(String email) {
		
		sessionFactory.getCurrentSession().delete(getUserByEmail(email));
		return true;
	}

	@Override
	public List<User> listAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public User getUserByEmail(String email) {
		
		return (User) sessionFactory.getCurrentSession().createQuery("from User where email='"+email+"'").uniqueResult();
	}

}
