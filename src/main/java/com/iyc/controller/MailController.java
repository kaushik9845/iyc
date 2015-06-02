package com.iyc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iyc.service.MailService;

@Controller
public class MailController {
	
	@Autowired
	MailService mailService;
	
	@RequestMapping(value="/sendMail",method=RequestMethod.POST)
	public ModelAndView  login(HttpServletRequest req,HttpSession session)
	{
		
		 String status=mailService.sendMail(req);
		 Map map= new HashMap();
		 
		 if(status.equals("success")) 
			 map.put("status", "A mail has been sent to the admin");
		 else
			 map.put("status", "Please try after some time");
		 
		 return new ModelAndView("BldReq","model",map);
	}
	
	

}
