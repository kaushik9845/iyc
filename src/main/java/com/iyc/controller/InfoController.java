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
import com.iyc.service.InfoService;

@Controller
public class InfoController {

	@Autowired
	InfoService InfoService;

	@RequestMapping(value="/addInfodata",method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody JSONObject addInfodata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		JSONObject obj= new JSONObject();

		try {
			obj.put("status",InfoService.addInfodata(uploadForm, req));
		} catch (IllegalStateException | IOException e) {
			obj.put("status",e.getMessage());
		}

		return obj;



	}

	@RequestMapping(value="/updateInfodata",method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody JSONObject updateInfodata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		JSONObject obj= new JSONObject();

		try {
			obj.put("status",InfoService.updateInfodata(uploadForm, req));
		} catch (IllegalStateException | IOException e) {
			obj.put("status",e.getMessage());
		}

		return obj;



	}

	@RequestMapping(value="/deleteInfodata",method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody JSONObject deleteInfodata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		JSONObject obj= new JSONObject();

		try {
			obj.put("status",InfoService.deleteInfodata(uploadForm, req));
		} catch (IllegalStateException | IOException e) {
			obj.put("status",e.getMessage());
		}

		return obj;

	}
	
	@RequestMapping(value="/getInfodata",method = RequestMethod.GET)
	public @ResponseBody JSONObject getInfodata(HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{
		JSONObject obj= new JSONObject();

		try {
			obj.put("data",InfoService.getInfodata(req));
		} catch (IllegalStateException e) {
			obj.put("data",e.getMessage());
		}

		return obj;

	}


	@RequestMapping(value="/getAllInfodetails",method = RequestMethod.GET)
	public @ResponseBody JSONObject getInfodetails(HttpServletRequest req,
			HttpServletResponse response, HttpSession session)
	{

		JSONObject obj= new JSONObject();
		obj.put("data",InfoService.getInfodata());
		return obj;	
	}



}
