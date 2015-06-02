package com.iyc.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.web.multipart.MultipartFile;

import com.iyc.entity.Services;


public interface ServicesSrv {
	
	JSONArray getServices();
	
	String editServices(Services service);
	
	String addServices(Services service);
	
	String deleteServices(Services service);
	
	void getServicesTemplate(HttpServletRequest req,
			HttpServletResponse response, HttpSession session) throws IOException;
	
	public  void readExcel(MultipartFile multipartFile) throws FileNotFoundException, IOException;

	

}
