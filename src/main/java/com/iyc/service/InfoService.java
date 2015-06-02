package com.iyc.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.iyc.bean.FileUploadForm;
import com.iyc.bean.InfoBean;


public interface InfoService {
	
	String addInfodata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req) throws IllegalStateException, IOException ;
	
	String updateInfodata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req) throws IllegalStateException, IOException ;
	
	String deleteInfodata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req) throws IllegalStateException, IOException ;
	
	List<InfoBean> getInfodata(HttpServletRequest req);
	
	List<InfoBean> getInfodata();
	
	void deleteImage(String imageName);

}
