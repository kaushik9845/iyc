package com.iyc.dao;

import java.util.List;

import com.iyc.entity.Category;


public interface CategoryDao {
	
	List<Category> getCategory();
	
	String editCategory(Category category);
	
	String addCategory(Category category);
	
	String deleteCategory(Category category);
	
	public boolean exist(Category category);

}
