package com.iyc.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.web.multipart.MultipartFile;

import com.iyc.bean.SubCategorybean;


public interface SubCategoryService {
	
	JSONArray getSubCategory();
	
	String editSubCategory(SubCategorybean subCategory);
	
	String addSubCategory(SubCategorybean subCategory);
	
	String deleteSubCategory(SubCategorybean subCategory);
	
	void getSubCategoryTemplate(HttpServletRequest req,
			HttpServletResponse response, HttpSession session) throws IOException;
	
	public  void readExcel(MultipartFile multipartFile) throws FileNotFoundException, IOException; 

}
