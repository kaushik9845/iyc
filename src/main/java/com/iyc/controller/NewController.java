package com.iyc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iyc.service.EventService;
import com.iyc.service.HomeService;
import com.iyc.service.InfoService;

@Controller
public class NewController {
	
	@Autowired
	EventService eventService;
	
	@Autowired
	InfoService infoService;
	
	@Autowired
	HomeService homeService;

	@RequestMapping(value="/getAlldetails",method = RequestMethod.GET)
	public @ResponseBody JSONObject getEventdetails(HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{

		JSONObject obj= new JSONObject();
		
		obj.put("home",eventService.getEventdata());
		obj.put("info",eventService.getEventdata());
		obj.put("event",eventService.getEventdata());
		
		return obj;	
	}
}
