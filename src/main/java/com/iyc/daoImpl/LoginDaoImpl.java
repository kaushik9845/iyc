package com.iyc.daoImpl;

import java.math.BigInteger;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iyc.dao.LoginDao;
import com.iyc.entity.User;

@Service
public class LoginDaoImpl implements LoginDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<User> validate(String uname, String pword) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where name=:uname and password=:pword");
		query.setParameter("uname", uname);
		query.setParameter("pword", pword);
		List<User> users=query.list();
		
		
		return users;
	}

	@Transactional
	public String addMobileUser(String name, String dob, BigInteger mobile) {
		Session session=sessionFactory.getCurrentSession();
		
		User user= new User();
		
		
		
		
		
		try
		{
			DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
			user.setMobile(mobile);
			user.setName(name);
			Date birthDate = (Date) df.parse(dob);
			user.setDob(birthDate);
			session.save(user);	
		}
		
		catch(Exception e)
		{
			return "failure";
		}
		
		
		
		return "success";
	}

	
}
