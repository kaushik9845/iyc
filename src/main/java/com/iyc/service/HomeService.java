package com.iyc.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.iyc.bean.FileUploadForm;
import com.iyc.bean.HomeBean;


public interface HomeService {
	
	String addHomedata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req) throws IllegalStateException, IOException ;
	
	String updateHomedata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req) throws IllegalStateException, IOException ;
	
	String deleteHomedata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req) throws IllegalStateException, IOException ;
	
	List<HomeBean> getHomedata(HttpServletRequest req);
	
	List<HomeBean> getHomedata();
	
	void deleteImage(String imageName);

}
