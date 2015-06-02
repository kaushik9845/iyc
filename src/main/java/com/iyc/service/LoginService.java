package com.iyc.service;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.web.servlet.ModelAndView;


public interface LoginService {
	
	ModelAndView validate(HttpServletRequest request,HttpSession session);
	
	JSONObject addMobileUser(String name, String dob, BigInteger mobile);
	
	

}
