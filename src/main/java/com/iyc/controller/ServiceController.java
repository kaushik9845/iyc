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
import com.iyc.entity.Services;
import com.iyc.service.ServicesSrv;

@Controller
public class ServiceController {
	
	@Autowired
	ServicesSrv   ServicesSrv;
	
	@RequestMapping(value="/getService",method = RequestMethod.GET)
	public @ResponseBody JSONObject getService()
	{
		JSONObject obj= new JSONObject();
		obj.put("data", ServicesSrv.getServices());
		return obj;
	}
	
	@RequestMapping(value="/editService",method = RequestMethod.POST,headers = "Accept=application/json")
	public @ResponseBody JSONObject getService(@RequestBody Services Service)
	{
		JSONObject obj= new JSONObject();
		obj.put("status", ServicesSrv.editServices(Service));
		return obj;
	}
	
	
	@RequestMapping(value="/addService",method = RequestMethod.POST,headers = "Accept=application/json")
	public @ResponseBody JSONObject addService(@RequestBody Services Service)
	{
		JSONObject obj= new JSONObject();
		obj.put("status", ServicesSrv.addServices(Service));
		return obj;
	}
	
	@RequestMapping(value="/deleteService",method = RequestMethod.POST,headers = "Accept=application/json")
	public @ResponseBody JSONObject deleteService(@RequestBody Services Service)
	{
		JSONObject obj= new JSONObject();
		obj.put("status", ServicesSrv.deleteServices(Service));
		return obj;
	}
	
	@RequestMapping(value="/getServiceTemplate",method = RequestMethod.GET)
	public void getServiceTemplate(HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		try {
			ServicesSrv.getServicesTemplate(req, response, session);
		} catch (IOException e) {
			try {
				response.getWriter().write("Error");
			} catch (IOException e1) {
				
			}
		}
	}
	
	@RequestMapping(value="/uploadService",method = RequestMethod.POST)
	public void uploadService(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		try {
			ServicesSrv.readExcel(uploadForm.getFiles().get(0));
		} catch (IOException e) {
			try {
				response.getWriter().write("Error");
			} catch (IOException e1) {
				
			}
		}
	}
	
	
	
	

}
