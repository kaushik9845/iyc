package com.iyc.daoImpl;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iyc.bean.DirectorySearchbean;
import com.iyc.bean.Directorybean;
import com.iyc.dao.DirectoryDao;
import com.iyc.entity.Area;
import com.iyc.entity.Directory;
import com.iyc.entity.Services;

@Service
public class DirectoryDaoImpl implements DirectoryDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Directory> getDirectory() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Directory order by id");
		
		List<Directory> directories=query.list();
		
		
		return directories;
	}

	@Transactional
	public List<Directory> getDirectorySearch(
			DirectorySearchbean directorySearchbean) {
		
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Directory.class);
		
		if(directorySearchbean.getServiceId()!=0) 
			criteria.add(Restrictions.eq("service.id", directorySearchbean.getServiceId()));
		
		if(directorySearchbean.getAreaId()!=0) 
			criteria.add(Restrictions.eq("area.id", directorySearchbean.getAreaId()));
		
		if(directorySearchbean.getImportant()!=2) 
			criteria.add(Restrictions.eq("important", directorySearchbean.getImportant()));
		
				
		List<Directory> directories=criteria.list();
		
		
		return directories;
	}

	@Transactional
	public String editDirectory(Directorybean directory) {
		
			Session session = sessionFactory.getCurrentSession();
			Area area=(Area) session.load(Area.class, directory.getAreaId());
			Services services=(Services) session.load(Services.class, directory.getServiceId());
			
			Directory dbdirectory=(Directory) session.load(Directory.class, directory.getId());
			dbdirectory.setArea(area);
			dbdirectory.setService(services);
			dbdirectory.setDescription(directory.getDescription());
			dbdirectory.setImportant(directory.getImportant());
			dbdirectory.setMobile(directory.getMobile());
			dbdirectory.setName(directory.getName());
			
			try {
				session.save(dbdirectory);
			} catch (Exception e) {
				return e.getMessage();
			}
			return "success";
		
		
	}

	@Transactional
	public String addDirectory(Directorybean directory) {
		
			Session session = sessionFactory.getCurrentSession();
			Area area=(Area) session.load(Area.class, directory.getAreaId());
			Services services=(Services) session.load(Services.class, directory.getServiceId());
			
			Directory dbdirectory=new Directory();
			dbdirectory.setArea(area);
			dbdirectory.setService(services);
			dbdirectory.setDescription(directory.getDescription());
			dbdirectory.setImportant(directory.getImportant());
			dbdirectory.setMobile(directory.getMobile());
			dbdirectory.setName(directory.getName());
			
			try {
				session.save(dbdirectory);
			} catch (Exception e) {
				return e.getMessage();
			}
			return "success";
		
	}

	@Transactional
	public String deleteDirectory(Directorybean directory) {
		Session session = sessionFactory.getCurrentSession();
		Directory dbdirectory=(Directory) session.load(Directory.class, directory.getId());
		
		try {
			session.delete(dbdirectory);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "success";
	
	}

	@Transactional
	public void addDirectoryExcel(Directorybean directory) {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria cr1= session.createCriteria(Area.class);
		cr1.add(Restrictions.eq("areaName",directory.getAreaName()));
		List<Area> areas=cr1.list();
		if(areas.size()!=0) directory.setAreaId(areas.get(0).getId());
		
		Criteria cr2= session.createCriteria(Services.class);
		cr2.add(Restrictions.eq("serviceName",directory.getServiceName()));
		List<Services> list=cr2.list();
		if(list.size()!=0) directory.setServiceId(list.get(0).getId());
		
		if(areas.size()!=0 && list.size()!=0) addDirectory(directory);
		
	}

	

}
