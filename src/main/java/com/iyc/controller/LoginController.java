package com.iyc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iyc.bean.mobileUser;
import com.iyc.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/validate")
	public ModelAndView login(HttpServletRequest req,HttpSession session)
	{
		return loginService.validate(req,session);
	}
	
	@RequestMapping(value="/addMobileUser",method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody JSONObject addMobileUser(@RequestBody mobileUser muser)
	{
		/*JSONObject obj= new JSONObject();
		obj.put("Hi", muser.getName());
		obj.put("mobile", muser.getMobile());
		obj.put("dob", muser.getDob());
		return obj;*/
		
		return loginService.addMobileUser(muser.getName(),  muser.getDob(), muser.getMobile());
	}

}
