package com.iyc.daoImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iyc.bean.HomeBean;
import com.iyc.dao.HomeDao;
import com.iyc.entity.Home;
import com.iyc.entity.SubCategory;
import com.iyc.entity.WebsiteCounter;

@Service
public class HomeDaoImpl implements HomeDao {

	@Autowired
	SessionFactory sessionFactory;


	

	@Transactional
	public String addHomedata(HomeBean home) {

		Session session=sessionFactory.getCurrentSession();

		Home entityhome= new Home();

		try
		{
			Date d = new Date();
			SubCategory subCat= (SubCategory) session.load(SubCategory.class, home.getSubCategoryId());
			entityhome.setDescription(home.getDescription());
			entityhome.setFileName(home.getFileName());
			entityhome.setTitle(home.getTitle());
			entityhome.setSubCategory(subCat);
			entityhome.setUpdatedTime(d);
			session.save(entityhome);	
		}

		catch(Exception e)
		{
			return "failure";
		}



		return "success";


	}


	@Transactional
	public String updateHomedata(HomeBean home) {
		Session session=sessionFactory.getCurrentSession();

		Home entityhome= (Home) session.load(Home.class, home.getId());

		try
		{
			Date d = new Date();
			
			SubCategory subCat= (SubCategory) session.load(SubCategory.class, home.getSubCategoryId());
			entityhome.setDescription(home.getDescription());
			if(home.getFileName()!=null)
			entityhome.setFileName(home.getFileName());
			entityhome.setUpdatedTime(d);
			entityhome.setTitle(home.getTitle());
			entityhome.setSubCategory(subCat);
			session.saveOrUpdate(entityhome);	
		}

		catch(Exception e)
		{
			return "failure";
		}



		return "success";

	}


	@Transactional
	public String deleteHomedata(HomeBean home) {
		Session session=sessionFactory.getCurrentSession();

		Home entityhome= (Home) session.load(Home.class, home.getId());

		try
		{
			session.delete(entityhome);	
		}

		catch(Exception e)
		{
			return "failure";
		}



		return "success";

	}


	@Transactional
	public List<Home> getHomedata(int subCategoryId) {
		Session session=sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Home where subCategoryId=:subCategoryId order by updatedTime desc");
		query.setParameter("subCategoryId", subCategoryId);
		ArrayList<Home> list= (ArrayList<Home>) query.list();
		return list;
	}

	@Transactional
	public List<Home> getAllHomedata() {
		Session session=sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Home order by updatedTime desc");
		ArrayList<Home> list= (ArrayList<Home>) query.list();
		return list;
	}


	@Transactional
	public String getImageName(int homeId) {
		Session session=sessionFactory.getCurrentSession();

		Home entityhome= (Home) session.load(Home.class, homeId);
		
		return entityhome.getFileName();
}


	@Transactional
	public int getWebSiteCount(HttpServletRequest req) {
		
		Session session=sessionFactory.getCurrentSession();
		
		WebsiteCounter websiteCounter=getCounterForIP(req.getRemoteAddr());
		
		int size=1;
		
		if (websiteCounter!=null) size=websiteCounter.getCounter()+1;
				
		if(size<2)
		{
		WebsiteCounter add= new WebsiteCounter();
		add.setIp(req.getRemoteAddr());
		add.setCounter(size);
		session.save(add);
		}
		else
		{
			WebsiteCounter update=websiteCounter;
			update.setCounter(size);
			session.saveOrUpdate(update);
		}
		Query query= session.createSQLQuery("select sum(counter) from WebsiteCounter");
		List<BigDecimal> list=query.list();
		if(list.get(0)!=null)
		{
		int count=list.get(0).intValue();
		return count;
		}
		else return 0;
	}

	@Transactional
	private WebsiteCounter getCounterForIP(String ipAddress)
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from WebsiteCounter where ip=:ipAddress");
		query.setParameter("ipAddress",ipAddress);
		List<WebsiteCounter> counterList= query.list();
		if(counterList.size()!=0)
		return counterList.get(0);
		else
			return null;
	}
}
