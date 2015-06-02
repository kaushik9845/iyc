package com.iyc.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iyc.dao.ServicesDao;
import com.iyc.entity.Services;

@Service
public class ServicesDaoImpl implements ServicesDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Services> getServices() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Services order by id");
		
		List<Services> services=query.list();
		
		
		return services;
	}

	@Transactional
	public String editServices(Services service) {
		
		
		if (!exist(service)) {
			Session session = sessionFactory.getCurrentSession();
			Services dbservice=(Services) session.load(Services.class, service.getId());
			dbservice.setServiceName(service.getServiceName());
			try {
				session.save(dbservice);
			} catch (Exception e) {
				return e.getMessage();
			}
			return "success";
		}
		else
		{
			return "Already Exists";
		}
		
			
	}
	
	
	@Transactional
	public String addServices(Services service) {
		
		
		if (!exist(service)) {
			Session session = sessionFactory.getCurrentSession();
			Services dbservice = new Services();
			dbservice.setServiceName(service.getServiceName());
			try {
				session.save(dbservice);
			} catch (Exception e) {
				return e.getMessage();
			}
			return "success";
		}
		else
		{
			return "Already Exists";
		}
	}
	
	@Transactional
	public String deleteServices(Services service) {
		Session session=sessionFactory.getCurrentSession();
			
		Services dbservice=(Services) session.load(Services.class, service.getId());
		
		try
		{
			session.delete(dbservice);
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		return "success";
	}
	
	@Transactional
	public boolean exist(Services service) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Services where serviceName=:service");
		query.setParameter("service", service.getServiceName());
		
		List<Services> list= query.list();
		if(list.size()==0)		
		return false;
		else return true;
			
	}
	

}
