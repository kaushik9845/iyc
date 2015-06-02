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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iyc.bean.DirectorySearchbean;
import com.iyc.bean.Directorybean;
import com.iyc.bean.FileUploadForm;
import com.iyc.entity.Directory;
import com.iyc.service.DirectoryService;

@Controller
public class DirectoryController {
	
	@Autowired
	DirectoryService   directoryService;
	
	@RequestMapping(value="/getDirectory",method = RequestMethod.GET)
	public @ResponseBody JSONObject getDirectory()
	{
		JSONObject obj= new JSONObject();
		obj.put("data", directoryService.getDirectory());
		return obj;
	}
	
	@RequestMapping(value="/getDirectorySearch",method = RequestMethod.GET)
	public @ResponseBody JSONObject getDirectorySearch(@RequestParam int serviceId,@RequestParam int areaId,@RequestParam int important)
	{
		DirectorySearchbean directorySearchbean= new DirectorySearchbean();
		directorySearchbean.setAreaId(areaId);
		directorySearchbean.setImportant(important);
		directorySearchbean.setServiceId(serviceId);
		JSONObject obj= new JSONObject();
		obj.put("data", directoryService.getDirectorySearch(directorySearchbean));
		return obj;
	}
	
	@RequestMapping(value="/editDirectory",method = RequestMethod.POST,headers = "Accept=application/json")
	public @ResponseBody JSONObject getDirectory(@RequestBody Directorybean directory)
	{
		JSONObject obj= new JSONObject();
		obj.put("status", directoryService.editDirectory(directory));
		return obj;
	}
	
	
	@RequestMapping(value="/addDirectory",method = RequestMethod.POST,headers = "Accept=application/json")
	public @ResponseBody JSONObject addDirectory(@RequestBody Directorybean directory)
	{
		JSONObject obj= new JSONObject();
		obj.put("status", directoryService.addDirectory(directory));
		return obj;
	}
	
	@RequestMapping(value="/deleteDirectory",method = RequestMethod.POST,headers = "Accept=application/json")
	public @ResponseBody JSONObject deleteDirectory(@RequestBody Directorybean directory)
	{
		JSONObject obj= new JSONObject();
		obj.put("status", directoryService.deleteDirectory(directory));
		return obj;
	}
	
	@RequestMapping(value="/getDirectoryTemplate",method = RequestMethod.GET)
	public void getDirectoryTemplate(HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		try {
			directoryService.getDirectoryTemplate(req, response, session);
		} catch (IOException e) {
			try {
				response.getWriter().write("Error");
			} catch (IOException e1) {
				
			}
		}
	}
	
	@RequestMapping(value="/uploadDirectory",method = RequestMethod.POST)
	public void uploadDirectory(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		try {
			directoryService.readExcel(uploadForm.getFiles().get(0));
		} catch (IOException e) {
			try {
				response.getWriter().write("Error");
			} catch (IOException e1) {
				
			}
		}
	}
	
	
	
	

}
