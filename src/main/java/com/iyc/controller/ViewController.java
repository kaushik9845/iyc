package com.iyc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iyc.dao.HomeDao;

@Controller
public class ViewController {
	
	@Autowired HomeDao homeDao;
	
	@RequestMapping(value="/login")
	public String login(HttpSession session)
	{
		session.invalidate();
		return "login";
	}
	
	
	
	@RequestMapping(value="/adminPanel")
	public String adminPanel(HttpSession session)
	{
		if(session.getAttribute("status")==null)
		{
			return "login";	
		}
		else if(session.getAttribute("status").equals("success"))
		{
			return "adminPanel";
		}
		else
		{
			return "login";	
		}
	}
	
	
	@RequestMapping(value="/adminDirectory")
	public String adminDirectory(HttpSession session)
	{
		if(session.getAttribute("status")==null)
		{
			return "login";	
		}
		else if(session.getAttribute("status").equals("success"))
		{
			return "adminDirectory";
		}
		else
		{
			return "login";	
		}
	}
	
	@RequestMapping(value="/adminInfo")
	public String adminInfo(HttpSession session)
	{
		if(session.getAttribute("status")==null)
		{
			return "login";	
		}
		else if(session.getAttribute("status").equals("success"))
		{
			return "adminInfo";
		}
		else
		{
			return "login";	
		}
	}
	
	@RequestMapping(value="/adminEvent")
	public String adminEvent(HttpSession session)
	{
		if(session.getAttribute("status")==null)
		{
			return "login";	
		}
		else if(session.getAttribute("status").equals("success"))
		{
			return "adminEvent";
		}
		else
		{
			return "login";	
		}
	}
	@RequestMapping(value="/subCategory")
	public String subCategory(HttpSession session)
	{
		if(session.getAttribute("status")==null)
		{
			return "login";	
		}
		else if(session.getAttribute("status").equals("success"))
		{
			return "SubCategory";
		}
		else
		{
			return "login";	
		}
	}
	
	@RequestMapping(value="/adminHome")
	public String adminHome(HttpSession session)
	{
		if(session.getAttribute("status")==null)
		{
			return "login";	
		}
		else if(session.getAttribute("status").equals("success"))
		{
			return "adminHome";
		}
		else
		{
			return "login";	
		}
	}
	
	
	@RequestMapping(value="/service")
	public String service(HttpSession session)
	{
		if(session.getAttribute("status")==null)
		{
			return "login";	
		}
		else if(session.getAttribute("status").equals("success"))
		{
			return "service";
		}
		else
		{
			return "login";	
		}
	}
	
	@RequestMapping(value="/area")
	public String area(HttpSession session)
	{
		if(session.getAttribute("status")==null)
		{
			return "login";	
		}
		else if(session.getAttribute("status").equals("success"))
		{
			return "area";
		}
		else
		{
			return "login";	
		}
	}
	
	@RequestMapping(value="/Home")
	public String Home(HttpSession session,HttpServletRequest req)
	{
		session.setAttribute("count", 1000+homeDao.getWebSiteCount(req));
		return "Home";
	}
	
	@RequestMapping(value="/Event")
	public String Event(HttpSession session)
	{
		return "Event";
	}
	
	@RequestMapping(value="/Info")
	public String Info(HttpSession session)
	{
		return "Info";
	}
	
	@RequestMapping(value="/Directory")
	public String Directory(HttpSession session)
	{
		return "Directory";
	}
	
	@RequestMapping(value="/BldReq")
	public String BldReq(HttpSession session)
	{
		return "BldReq";
	}
	
	@RequestMapping(value="/AboutUs")
	public String AboutUs(HttpSession session)
	{
		return "AboutUs";
	}
	
	@RequestMapping(value="/ContactUs")
	public String ContactUs(HttpSession session)
	{
		return "ContactUs";
	}
	
	@RequestMapping(value="/ImportantContacts")
	public String ImportantContacts(HttpSession session)
	{
		return "ImportantContacts";
	}
	
	@RequestMapping(value="/searchDirectory")
	public String searchDirectory(HttpSession session)
	{
		return "searchDirectory";
	}

}
