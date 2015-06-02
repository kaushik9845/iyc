package com.iyc.serviceImpl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.iyc.dao.LoginDao;
import com.iyc.entity.User;
import com.iyc.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginDao loginDao;

	@Override
	public ModelAndView validate(HttpServletRequest request,HttpSession session) {
		
		ModelAndView mv= new ModelAndView();
		
		
		String uname=request.getParameter("userName");
		String pword=request.getParameter("password");
		List<User> users= loginDao.validate(uname, pword);
		
		Map<String,String> map= new HashMap<String,String>();
		
		if(users.size()==0)
		{
			map.put("status", "failure");
			mv.setViewName("login");
			
		}
		else
		{
			map.put("status", "success");
			session.setAttribute("status", "success");
			session.setAttribute("userName", uname);
			mv.setViewName("adminHome");
			
		}
		
		mv.addObject("model", map);
		
		return mv;
	}

	@Override
	public JSONObject addMobileUser(String name, String dob, BigInteger mobile) {
		
		JSONObject obj= new JSONObject();
		obj.put("status", loginDao.addMobileUser(name, dob, mobile));
		
		return obj;
	}
	
	

}
