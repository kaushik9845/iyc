package com.iyc.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.web.multipart.MultipartFile;

import com.iyc.bean.DirectorySearchbean;
import com.iyc.bean.Directorybean;
import com.iyc.entity.Directory;


public interface DirectoryService {
	
	JSONArray getDirectory();
	
	JSONArray getDirectorySearch(DirectorySearchbean directorySearchbean);
	
	String editDirectory(Directorybean directory);
	
	String addDirectory(Directorybean directory);
	
	String deleteDirectory(Directorybean directory);
	
	void getDirectoryTemplate(HttpServletRequest req,
			HttpServletResponse response, HttpSession session) throws IOException;
	
	public  void readExcel(MultipartFile multipartFile) throws FileNotFoundException, IOException; 

}
