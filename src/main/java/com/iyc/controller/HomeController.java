package com.iyc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iyc.bean.FileUploadForm;
import com.iyc.service.HomeService;

@Controller
public class HomeController {

	@Autowired
	HomeService homeService;

	@RequestMapping(value="/addHomedata",method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody JSONObject addHomedata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		JSONObject obj= new JSONObject();

		try {
			obj.put("status",homeService.addHomedata(uploadForm, req));
		} catch (IllegalStateException | IOException e) {
			obj.put("status",e.getMessage());
		}

		return obj;



	}

	@RequestMapping(value="/updateHomedata",method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody JSONObject updateHomedata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		JSONObject obj= new JSONObject();

		try {
			obj.put("status",homeService.updateHomedata(uploadForm, req));
		} catch (IllegalStateException | IOException e) {
			obj.put("status",e.getMessage());
		}

		return obj;



	}

	@RequestMapping(value="/deleteHomedata",method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody JSONObject deleteHomedata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		JSONObject obj= new JSONObject();

		try {
			obj.put("status",homeService.deleteHomedata(uploadForm, req));
		} catch (IllegalStateException | IOException e) {
			obj.put("status",e.getMessage());
		}

		return obj;

	}
	
	@RequestMapping(value="/getHomedata",method = RequestMethod.GET)
	public @ResponseBody JSONObject getHomedata(HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		JSONObject obj= new JSONObject();

		try {
			
			
			obj.put("data",homeService.getHomedata(req));
			
		} catch (IllegalStateException e) {
			obj.put("data",e.getMessage());
		}

		return obj;

	}


	@RequestMapping(value="/getAllHomedetails",method = RequestMethod.GET)
	public @ResponseBody JSONObject getHomedetails(HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{

		JSONObject obj= new JSONObject();
		obj.put("data",homeService.getHomedata());
		return obj;	
	}



}
