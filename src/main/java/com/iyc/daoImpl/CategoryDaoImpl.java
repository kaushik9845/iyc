package com.iyc.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iyc.dao.CategoryDao;
import com.iyc.entity.Category;

@Service
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Category> getCategory() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Category order by id");
		
		List<Category> categorys=query.list();
		
		
		return categorys;
	}

	@Transactional
	public String editCategory(Category category) {
		
		
		if (!exist(category)) {
			Session session = sessionFactory.getCurrentSession();
			Category dbcategory=(Category) session.load(Category.class, category.getId());
			dbcategory.setCategory(category.getCategory());
			try {
				session.save(dbcategory);
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
	public String addCategory(Category category) {
		
		
		if (!exist(category)) {
			Session session = sessionFactory.getCurrentSession();
			Category dbcategory = new Category();
			dbcategory.setCategory(category.getCategory());
			try {
				session.save(dbcategory);
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
	public String deleteCategory(Category category) {
		Session session=sessionFactory.getCurrentSession();
			
		Category dbcategory=(Category) session.load(Category.class, category.getId());
		
		try
		{
			session.delete(dbcategory);
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		return "success";
	}
	
	@Transactional
	public boolean exist(Category category) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Category where category=:category");
		query.setParameter("category", category.getCategory());
		
		List<Category> list= query.list();
		if(list.size()==0)		
		return false;
		else return true;
			
	}
	

}
