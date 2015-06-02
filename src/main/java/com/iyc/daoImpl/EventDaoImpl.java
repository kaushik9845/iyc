package com.iyc.daoImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iyc.bean.EventBean;
import com.iyc.dao.EventDao;
import com.iyc.entity.Event;
import com.iyc.entity.SubCategory;

@Service
public class EventDaoImpl implements EventDao {

	@Autowired
	SessionFactory sessionFactory;


	

	@Transactional
	public String addEventdata(EventBean Event) {

		Session session=sessionFactory.getCurrentSession();

		Event entityEvent= new Event();

		try
		{
			
			SubCategory subCat= (SubCategory) session.load(SubCategory.class, Event.getSubCategoryId());
			entityEvent.setDescription(Event.getDescription());
			entityEvent.setFileName(Event.getFileName());
			entityEvent.setTitle(Event.getTitle());
			entityEvent.setSubCategory(subCat);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy/MM/dd HH:mm");
			
			try {
				Date schedule=dateFormat.parse(Event.getUpdatedDate());
				entityEvent.setTime(schedule);
			} catch (ParseException e) {
				return e.getMessage();
			}
			
			entityEvent.setPlace(Event.getPlace());
			session.save(entityEvent);	
		}

		catch(Exception e)
		{
			return "failure";
		}



		return "success";


	}


	@Transactional
	public String updateEventdata(EventBean Event) {
		Session session=sessionFactory.getCurrentSession();

		Event entityEvent= (Event) session.load(Event.class, Event.getId());

		try
		{
			
			
			SubCategory subCat= (SubCategory) session.load(SubCategory.class, Event.getSubCategoryId());
			entityEvent.setDescription(Event.getDescription());
			if(Event.getFileName()!=null)
			entityEvent.setFileName(Event.getFileName());
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy/MM/dd HH:mm");
			
			try {
				Date schedule=dateFormat.parse(Event.getUpdatedDate());
				entityEvent.setTime(schedule);
			} catch (ParseException e) {
				return e.getMessage();
			}
			entityEvent.setTitle(Event.getTitle());
			entityEvent.setSubCategory(subCat);
			entityEvent.setPlace(Event.getPlace());
			session.saveOrUpdate(entityEvent);	
		}

		catch(Exception e)
		{
			return "failure";
		}



		return "success";

	}


	@Transactional
	public String deleteEventdata(EventBean Event) {
		Session session=sessionFactory.getCurrentSession();

		Event entityEvent= (Event) session.load(Event.class, Event.getId());

		try
		{
			session.delete(entityEvent);	
		}

		catch(Exception e)
		{
			return "failure";
		}



		return "success";

	}


	@Transactional
	public List<Event> getEventdata(int subCategoryId) {
		Session session=sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Event where subCategoryId=:subCategoryId order by Time desc");
		query.setParameter("subCategoryId", subCategoryId);
		ArrayList<Event> list= (ArrayList<Event>) query.list();
		return list;
	}

	@Transactional
	public List<Event> getAllEventdata() {
		Session session=sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Event order by Time desc");
		ArrayList<Event> list= (ArrayList<Event>) query.list();
		return list;
	}


	@Transactional
	public String getImageName(int EventId) {
		Session session=sessionFactory.getCurrentSession();

		Event entityEvent= (Event) session.load(Event.class, EventId);
		
		return entityEvent.getFileName();
				

	}


}
