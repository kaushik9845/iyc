package com.iyc.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iyc.bean.SubCategorybean;
import com.iyc.dao.SubCategoryDao;
import com.iyc.entity.Category;
import com.iyc.entity.SubCategory;

@Service
public class SubCategoryDaoImpl implements SubCategoryDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<SubCategory> getSubCategory() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from SubCategory order by id");
		
		List<SubCategory> subCategorys=query.list();
		
		
		return subCategorys;
	}

	@Transactional
	public String editSubCategory(SubCategorybean subCategory) {
		
		if(!exist(subCategory))
		{
		Session session=sessionFactory.getCurrentSession();
		SubCategory dbsubCategory=(SubCategory) session.load(SubCategory.class, subCategory.getId());
		dbsubCategory.setSubcategory(subCategory.getSubCategory());
		Category category= (Category) session.load(Category.class,subCategory.getCategoryId());
		dbsubCategory.setCategory(category);
		try
		{
			
			session.update(dbsubCategory);
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		return "success";
		}
		else return "Already Exists";
			
	}
	
	@Transactional
	public int getIdfromName(String name)
	{
		Session session=sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Category where category=:name");
		query.setParameter("name", name);
		List<Category> categorys= query.list();
		if(categorys.size()==0) return 0;
		else
		return categorys.get(0).getId();
	}
	
	
	@Transactional
	public String addSubCategory(SubCategorybean subCategory) {
		
		if(!exist(subCategory))
		{
		Session session=sessionFactory.getCurrentSession();
			
		SubCategory dbsubCategory= new SubCategory();
		dbsubCategory.setSubcategory(subCategory.getSubCategory());
		Category category= (Category) session.load(Category.class,subCategory.getCategoryId());
		dbsubCategory.setCategory(category);
		
		
		try
		{
			
			session.save(dbsubCategory);
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		return "success";
		}
		else return "Already Exists";
			
	}
	
	@Transactional
	public String deleteSubCategory(SubCategorybean subCategory) {
		Session session=sessionFactory.getCurrentSession();
			
		SubCategory dbsubCategory=(SubCategory) session.load(SubCategory.class, subCategory.getId());
		
		try
		{
			session.delete(dbsubCategory);
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		return "success";
	}
	
	@Transactional
	public boolean exist(SubCategorybean subCategory) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from SubCategory where category.id=:categoryId and subcategory=:subCategory");
		query.setParameter("categoryId", subCategory.getCategoryId());
		query.setParameter("subCategory", subCategory.getSubCategory());
		List<SubCategory> list= query.list();
		if(list.size()==0)		
		return false;
		else return true;
			
	}
	
	

}
