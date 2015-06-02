package com.iyc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iyc.bean.FileUploadForm;
import com.iyc.bean.SubCategorybean;
import com.iyc.service.SubCategoryService;

@Controller
public class SubCategoryController {
	
	@Autowired
	SubCategoryService   subCategoryService;
	
	@RequestMapping(value="/getSubCategory",method = RequestMethod.GET)
	public @ResponseBody JSONObject getSubCategory()
	{
		JSONObject obj= new JSONObject();
		obj.put("data", subCategoryService.getSubCategory());
		return obj;
	}
	
	@RequestMapping(value="/editSubCategory",method = RequestMethod.POST,headers = "Accept=application/json")
	public @ResponseBody JSONObject getSubCategory(@RequestBody SubCategorybean subCategory)
	{
		JSONObject obj= new JSONObject();
		obj.put("status", subCategoryService.editSubCategory(subCategory));
		return obj;
	}
	
	
	@RequestMapping(value="/addSubCategory",method = RequestMethod.POST,headers = "Accept=application/json")
	public @ResponseBody JSONObject addSubCategory(@RequestBody SubCategorybean subCategory)
	{
		JSONObject obj= new JSONObject();
		obj.put("status", subCategoryService.addSubCategory(subCategory));
		return obj;
	}
	
	@RequestMapping(value="/deleteSubCategory",method = RequestMethod.POST,headers = "Accept=application/json")
	public @ResponseBody JSONObject deleteSubCategory(@RequestBody SubCategorybean subCategory)
	{
		JSONObject obj= new JSONObject();
		obj.put("status", subCategoryService.deleteSubCategory(subCategory));
		return obj;
	}
	
	@RequestMapping(value="/getSubCategoryTemplate",method = RequestMethod.GET)
	public void getSubCategoryTemplate(HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		try {
			subCategoryService.getSubCategoryTemplate(req, response, session);
		} catch (IOException e) {
			try {
				response.getWriter().write("Error");
			} catch (IOException e1) {
				
			}
		}
	}
	
	@RequestMapping(value="/uploadSubCategory",method = RequestMethod.POST)
	public void uploadSubCategory(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		try {
			subCategoryService.readExcel(uploadForm.getFiles().get(0));
		} catch (IOException e) {
			try {
				response.getWriter().write("Error");
			} catch (IOException e1) {
				
			}
		}
	}
	
	
	
	

}
