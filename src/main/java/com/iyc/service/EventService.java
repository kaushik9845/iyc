package com.iyc.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.iyc.bean.FileUploadForm;
import com.iyc.bean.EventBean;


public interface EventService {
	
	String addEventdata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req) throws IllegalStateException, IOException ;
	
	String updateEventdata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req) throws IllegalStateException, IOException ;
	
	String deleteEventdata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req) throws IllegalStateException, IOException ;
	
	List<EventBean> getEventdata(HttpServletRequest req);
	
	List<EventBean> getEventdata();
	
	void deleteImage(String imageName);

}
