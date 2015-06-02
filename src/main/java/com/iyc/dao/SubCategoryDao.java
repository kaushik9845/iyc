package com.iyc.dao;

import java.util.List;

import com.iyc.bean.SubCategorybean;
import com.iyc.entity.SubCategory;


public interface SubCategoryDao {
	
	List<SubCategory> getSubCategory();
	
	String editSubCategory(SubCategorybean subCategory);
	
	String addSubCategory(SubCategorybean subCategory);
	
	String deleteSubCategory(SubCategorybean subCategory);
	
	int getIdfromName(String name);
	
	public boolean exist(SubCategorybean subCategory); 

}
