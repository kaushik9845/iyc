package com.iyc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class  ImageController{
	
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * Logger variable for logging errors.
	 */
	protected final static Logger logger = Logger
			.getLogger(ImageController.class);
	
	@RequestMapping(value="/getImage")
	public void  getImage(HttpServletRequest request,HttpServletResponse response) 
	{
		
		String helpFilePath = messageSource.getMessage("image.path",
				new Object[] {}, null);
		
			
		String fileName=request.getParameter("fileName");
		
		
		File filename= new File(helpFilePath+File.separator+fileName);
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(filename);
			response.setHeader(
					"Content-Disposition",
					"attachment; filename=\""
							+ fileName + "\"");
			FileCopyUtils.copy(fis, response.getOutputStream());
		} catch (FileNotFoundException e) {
			
			logger.error("ImageController:getImage:"+e.getMessage());
			
		} catch (IOException e) {
			
			logger.error("ImageController:getImage:"+e.getMessage());
		}
		
		
	}
	
	
}
