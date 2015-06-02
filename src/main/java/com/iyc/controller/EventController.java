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
import com.iyc.service.EventService;

@Controller
public class EventController {

	@Autowired
	EventService EventService;

	@RequestMapping(value="/addEventdata",method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody JSONObject addEventdata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		JSONObject obj= new JSONObject();

		try {
			obj.put("status",EventService.addEventdata(uploadForm, req));
		} catch (IllegalStateException | IOException e) {
			obj.put("status",e.getMessage());
		}

		return obj;



	}

	@RequestMapping(value="/updateEventdata",method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody JSONObject updateEventdata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		JSONObject obj= new JSONObject();

		try {
			obj.put("status",EventService.updateEventdata(uploadForm, req));
		} catch (IllegalStateException | IOException e) {
			obj.put("status",e.getMessage());
		}

		return obj;



	}

	@RequestMapping(value="/deleteEventdata",method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody JSONObject deleteEventdata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		JSONObject obj= new JSONObject();

		try {
			obj.put("status",EventService.deleteEventdata(uploadForm, req));
		} catch (IllegalStateException | IOException e) {
			obj.put("status",e.getMessage());
		}

		return obj;

	}
	
	@RequestMapping(value="/getEventdata",method = RequestMethod.GET)
	public @ResponseBody JSONObject getEventdata(HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		JSONObject obj= new JSONObject();

		try {
			obj.put("data",EventService.getEventdata(req));
		} catch (IllegalStateException e) {
			obj.put("data",e.getMessage());
		}

		return obj;

	}


	@RequestMapping(value="/getAllEventdetails",method = RequestMethod.GET)
	public @ResponseBody JSONObject getEventdetails(HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{

		JSONObject obj= new JSONObject();
		obj.put("data",EventService.getEventdata());
		return obj;	
	}



}
