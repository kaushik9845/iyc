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
import com.iyc.entity.Category;
import com.iyc.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService   categoryService;
	
	@RequestMapping(value="/getCategory",method = RequestMethod.GET)
	public @ResponseBody JSONObject getCategory()
	{
		JSONObject obj= new JSONObject();
		obj.put("data", categoryService.getCategory());
		return obj;
	}
	
	@RequestMapping(value="/editCategory",method = RequestMethod.POST,headers = "Accept=application/json")
	public @ResponseBody JSONObject getCategory(@RequestBody Category category)
	{
		JSONObject obj= new JSONObject();
		obj.put("status", categoryService.editCategory(category));
		return obj;
	}
	
	
	@RequestMapping(value="/addCategory",method = RequestMethod.POST,headers = "Accept=application/json")
	public @ResponseBody JSONObject addCategory(@RequestBody Category category)
	{
		JSONObject obj= new JSONObject();
		obj.put("status", categoryService.addCategory(category));
		return obj;
	}
	
	@RequestMapping(value="/deleteCategory",method = RequestMethod.POST,headers = "Accept=application/json")
	public @ResponseBody JSONObject deleteCategory(@RequestBody Category category)
	{
		JSONObject obj= new JSONObject();
		obj.put("status", categoryService.deleteCategory(category));
		return obj;
	}
	
	@RequestMapping(value="/getCategoryTemplate",method = RequestMethod.GET)
	public void getCategoryTemplate(HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		try {
			categoryService.getCategoryTemplate(req, response, session);
		} catch (IOException e) {
			try {
				response.getWriter().write("Error");
			} catch (IOException e1) {
				
			}
		}
	}
	
	@RequestMapping(value="/uploadCategory",method = RequestMethod.POST)
	public void uploadCategory(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		try {
			categoryService.readExcel(uploadForm.getFiles().get(0));
		} catch (IOException e) {
			try {
				response.getWriter().write("Error");
			} catch (IOException e1) {
				
			}
		}
	}
	
	
	
	

}
