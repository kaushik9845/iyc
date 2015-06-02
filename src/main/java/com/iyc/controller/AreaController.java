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
import com.iyc.entity.Area;
import com.iyc.service.AreaService;

@Controller
public class AreaController {
	
	@Autowired
	AreaService   areaService;
	
	@RequestMapping(value="/getArea",method = RequestMethod.GET)
	public @ResponseBody JSONObject getArea()
	{
		JSONObject obj= new JSONObject();
		obj.put("data", areaService.getArea());
		return obj;
	}
	
	@RequestMapping(value="/editArea",method = RequestMethod.POST,headers = "Accept=application/json")
	public @ResponseBody JSONObject getArea(@RequestBody Area area)
	{
		JSONObject obj= new JSONObject();
		obj.put("status", areaService.editArea(area));
		return obj;
	}
	
	
	@RequestMapping(value="/addArea",method = RequestMethod.POST,headers = "Accept=application/json")
	public @ResponseBody JSONObject addArea(@RequestBody Area area)
	{
		JSONObject obj= new JSONObject();
		obj.put("status", areaService.addArea(area));
		return obj;
	}
	
	@RequestMapping(value="/deleteArea",method = RequestMethod.POST,headers = "Accept=application/json")
	public @ResponseBody JSONObject deleteArea(@RequestBody Area area)
	{
		JSONObject obj= new JSONObject();
		obj.put("status", areaService.deleteArea(area));
		return obj;
	}
	
	@RequestMapping(value="/getAreaTemplate",method = RequestMethod.GET)
	public void getAreaTemplate(HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		try {
			areaService.getAreaTemplate(req, response, session);
		} catch (IOException e) {
			try {
				response.getWriter().write("Error");
			} catch (IOException e1) {
				
			}
		}
	}
	
	@RequestMapping(value="/uploadArea",method = RequestMethod.POST)
	public void uploadArea(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		try {
			areaService.readExcel(uploadForm.getFiles().get(0));
		} catch (IOException e) {
			try {
				response.getWriter().write("Error");
			} catch (IOException e1) {
				
			}
		}
	}
	
	
	
	

}
