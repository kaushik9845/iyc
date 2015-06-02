package com.iyc.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iyc.bean.InfoBean;
import com.iyc.dao.InfoDao;
import com.iyc.entity.Info;
import com.iyc.entity.SubCategory;

@Service
public class InfoDaoImpl implements InfoDao {

	@Autowired
	SessionFactory sessionFactory;


	

	@Transactional
	public String addInfodata(InfoBean Info) {

		Session session=sessionFactory.getCurrentSession();

		Info entityInfo= new Info();

		try
		{
			Date d = new Date();
			SubCategory subCat= (SubCategory) session.load(SubCategory.class, Info.getSubCategoryId());
			entityInfo.setDescription(Info.getDescription());
			entityInfo.setFileName(Info.getFileName());
			entityInfo.setTitle(Info.getTitle());
			entityInfo.setSubCategory(subCat);
			entityInfo.setUpdatedTime(d);
			session.save(entityInfo);	
		}

		catch(Exception e)
		{
			return "failure";
		}



		return "success";


	}


	@Transactional
	public String updateInfodata(InfoBean Info) {
		Session session=sessionFactory.getCurrentSession();

		Info entityInfo= (Info) session.load(Info.class, Info.getId());

		try
		{
			Date d = new Date();
			
			SubCategory subCat= (SubCategory) session.load(SubCategory.class, Info.getSubCategoryId());
			entityInfo.setDescription(Info.getDescription());
			if(Info.getFileName()!=null)
			entityInfo.setFileName(Info.getFileName());
			entityInfo.setUpdatedTime(d);
			entityInfo.setTitle(Info.getTitle());
			entityInfo.setSubCategory(subCat);
			session.saveOrUpdate(entityInfo);	
		}

		catch(Exception e)
		{
			return "failure";
		}



		return "success";

	}


	@Transactional
	public String deleteInfodata(InfoBean Info) {
		Session session=sessionFactory.getCurrentSession();

		Info entityInfo= (Info) session.load(Info.class, Info.getId());

		try
		{
			session.delete(entityInfo);	
		}

		catch(Exception e)
		{
			return "failure";
		}



		return "success";

	}


	@Transactional
	public List<Info> getInfodata(int subCategoryId) {
		Session session=sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Info where subCategoryId=:subCategoryId order by updatedTime desc");
		query.setParameter("subCategoryId", subCategoryId);
		ArrayList<Info> list= (ArrayList<Info>) query.list();
		return list;
	}

	@Transactional
	public List<Info> getAllInfodata() {
		Session session=sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Info order by updatedTime desc");
		ArrayList<Info> list= (ArrayList<Info>) query.list();
		return list;
	}


	@Transactional
	public String getImageName(int InfoId) {
		Session session=sessionFactory.getCurrentSession();

		Info entityInfo= (Info) session.load(Info.class, InfoId);
		
		return entityInfo.getFileName();
				

	}


}
