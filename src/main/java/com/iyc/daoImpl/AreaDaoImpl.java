package com.iyc.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iyc.dao.AreaDao;
import com.iyc.entity.Area;

@Service
public class AreaDaoImpl implements AreaDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Area> getArea() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Area order by id");
		
		List<Area> areas=query.list();
		
		
		return areas;
	}

	@Transactional
	public String editArea(Area area) {
		
		
		if (!exist(area)) {
			Session session = sessionFactory.getCurrentSession();
			Area dbarea=(Area) session.load(Area.class, area.getId());
			dbarea.setAreaName(area.getAreaName());
			try {
				session.save(dbarea);
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
	public String addArea(Area area) {
		
		
		if (!exist(area)) {
			Session session = sessionFactory.getCurrentSession();
			Area dbarea = new Area();
			dbarea.setAreaName(area.getAreaName());
			try {
				session.save(dbarea);
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
	public String deleteArea(Area area) {
		Session session=sessionFactory.getCurrentSession();
			
		Area dbarea=(Area) session.load(Area.class, area.getId());
		
		try
		{
			session.delete(dbarea);
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		return "success";
	}
	
	@Transactional
	public boolean exist(Area area) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Area where areaName=:area");
		query.setParameter("area", area.getAreaName());
		
		List<Area> list= query.list();
		if(list.size()==0)		
		return false;
		else return true;
			
	}
	

}
