package com.iyc.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.iyc.bean.EventBean;
import com.iyc.bean.FileUploadForm;
import com.iyc.dao.EventDao;
import com.iyc.entity.Event;
import com.iyc.service.EventService;

@Service
public class EventServiceImpl implements EventService {


	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	EventDao Eventdao;
	
	@Override
	public String addEventdata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req) throws IllegalStateException, IOException {
		
		
		String helpFilePath = messageSource.getMessage("image.path",
				new Object[] {}, null);
		
		MultipartFile multipartFile=uploadForm.getFiles().get(0);
		
		String fileName=multipartFile.getOriginalFilename();
		
		//Add to DB
		EventBean EventBean= new EventBean();
		EventBean.setFileName(fileName);
		EventBean.setDescription(req.getParameter("description"));
		EventBean.setTitle(req.getParameter("title"));
		EventBean.setId(0);
		int SubCategoryId=Integer.parseInt(req.getParameter("selectCategory"));
		EventBean.setSubCategoryId(SubCategoryId);
		
		EventBean.setPlace(req.getParameter("place"));
		String date=req.getParameter("schedule");
		EventBean.setUpdatedDate(date);
		
		
		Eventdao.addEventdata(EventBean);
		
		//Save image file
		File imageFile= new File(helpFilePath+File.separator+fileName);
		
		multipartFile.transferTo(imageFile);
		
		return "Success";
	}
	
	

	@Override
	public String updateEventdata(FileUploadForm uploadForm,
			HttpServletRequest req) throws IllegalStateException, IOException {
		String helpFilePath = messageSource.getMessage("image.path",
				new Object[] {}, null);
		
		MultipartFile multipartFile=uploadForm.getFiles().get(0);
		
		String fileName=multipartFile.getOriginalFilename();
		
		//Add to DB
		EventBean EventBean= new EventBean();
		
		EventBean.setDescription(req.getParameter("description"));
		EventBean.setTitle(req.getParameter("title"));
		int EventId=Integer.parseInt(req.getParameter("EventId"));
		EventBean.setId(EventId);
		int SubCategoryId=Integer.parseInt(req.getParameter("selectCategory"));
		EventBean.setSubCategoryId(SubCategoryId);
		
		if(fileName!="")
		//delete the previous image before updating to new
		{
		String imageName=Eventdao.getImageName(EventId);
		deleteImage(imageName);
		EventBean.setFileName(fileName);
		}
		
		EventBean.setPlace(req.getParameter("place"));
		String date=req.getParameter("schedule");
		
		EventBean.setUpdatedDate(date);
		
		Eventdao.updateEventdata(EventBean);
		
		//Save image file
		File imageFile= new File(helpFilePath+File.separator+fileName);
		
		multipartFile.transferTo(imageFile);
		
		return "Success";
	}
	@Override
	public String deleteEventdata(FileUploadForm uploadForm,
			HttpServletRequest req) throws IllegalStateException, IOException {
		
		//Add to DB
		EventBean EventBean= new EventBean();
		
		EventBean.setDescription(req.getParameter("description"));
		EventBean.setTitle(req.getParameter("title"));
		int EventId=Integer.parseInt(req.getParameter("EventId"));
		EventBean.setId(EventId);
		int SubCategoryId=Integer.parseInt(req.getParameter("selectCategory"));
		EventBean.setSubCategoryId(SubCategoryId);
		
		String imageName=Eventdao.getImageName(EventId);
		deleteImage(imageName);
		
		Eventdao.deleteEventdata(EventBean);
		
		
	
		return "Success";	}

	@Override
	public List<EventBean> getEventdata(HttpServletRequest req) {
		int subCategoryId=Integer.parseInt(req.getParameter("selectCategory"));
		if(subCategoryId==19)
		{
			return getEventdata();
		}
		List<Event> EventList=Eventdao.getEventdata(subCategoryId);
		int size=EventList.size();
		List<EventBean> EventBeanList= new ArrayList<EventBean>(); 
		for(Event Event:EventList)
		{
			EventBean bean= new EventBean();
			bean.setDescription(Event.getDescription());
			if(Event.getDescription().length()>50)
				bean.setShortDescription(Event.getDescription().substring(0, 50));
				else
					bean.setShortDescription(Event.getDescription());
			bean.setFileName("/iyc/getImage?fileName="+Event.getFileName());
			bean.setTitle(Event.getTitle());
			bean.setId(Event.getId());
			bean.setSubCategoryId(subCategoryId);
			bean.setSubCategory(Event.getSubCategory().getSubcategory());
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm");
			bean.setUpdatedDate(dateFormat.format(Event.getTime()));
			bean.setPlace(Event.getPlace());
			EventBeanList.add(bean);
		}
		return EventBeanList;
	}
	
	@Override
	public void deleteImage(String imageName)
	{
		try {
			
			String helpFilePath = messageSource.getMessage("image.path",
					new Object[] {}, null);
			
			File file= new File(helpFilePath+File.separator+imageName);
			file.delete();
		} catch (Exception e) {
			//Dont do anything if there is no file
			e.getMessage();
		}
		
	}



	@Override
	public List<EventBean> getEventdata() {
		List<Event> EventList=Eventdao.getAllEventdata();
		int size=EventList.size();
		List<EventBean> EventBeanList= new ArrayList<EventBean>(); 
		for(Event Event:EventList)
		{
			EventBean bean= new EventBean();
			bean.setDescription(Event.getDescription());
			if(Event.getDescription().length()>50)
				bean.setShortDescription(Event.getDescription().substring(0, 50));
				else
					bean.setShortDescription(Event.getDescription());
			bean.setFileName("/iyc/getImage?fileName="+Event.getFileName());
			bean.setTitle(Event.getTitle());
			bean.setId(Event.getId());
			bean.setSubCategoryId(Event.getSubCategory().getId());
			bean.setSubCategory(Event.getSubCategory().getSubcategory());
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm");
			bean.setUpdatedDate(dateFormat.format(Event.getTime()));
			bean.setPlace(Event.getPlace());
			EventBeanList.add(bean);
		}
		return EventBeanList;
	}
	
	public static void main(String[] args) {
		
		EventServiceImpl EventServiceImpl= new EventServiceImpl();
		EventServiceImpl.deleteImage("E:\\images\\iyc\\Image2888.jpg");
	}

}
