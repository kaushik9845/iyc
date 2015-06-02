package com.iyc.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.iyc.bean.FileUploadForm;
import com.iyc.bean.HomeBean;
import com.iyc.dao.HomeDao;
import com.iyc.entity.Home;
import com.iyc.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {


	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	HomeDao homedao;
	
	@Override
	public String addHomedata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req) throws IllegalStateException, IOException {
		
		
		String helpFilePath = messageSource.getMessage("image.path",
				new Object[] {}, null);
		
		MultipartFile multipartFile=uploadForm.getFiles().get(0);
		
		String fileName=multipartFile.getOriginalFilename();
		
		//Add to DB
		HomeBean homeBean= new HomeBean();
		homeBean.setFileName(fileName);
		homeBean.setDescription(req.getParameter("description"));
		homeBean.setTitle(req.getParameter("title"));
		homeBean.setId(0);
		int SubCategoryId=Integer.parseInt(req.getParameter("selectCategory"));
		homeBean.setSubCategoryId(SubCategoryId);
		
		homedao.addHomedata(homeBean);
		
		//Save image file
		File imageFile= new File(helpFilePath+File.separator+fileName);
		
		multipartFile.transferTo(imageFile);
		
		return "Success";
	}
	
	

	@Override
	public String updateHomedata(FileUploadForm uploadForm,
			HttpServletRequest req) throws IllegalStateException, IOException {
		String helpFilePath = messageSource.getMessage("image.path",
				new Object[] {}, null);
		
		MultipartFile multipartFile=uploadForm.getFiles().get(0);
		
		String fileName=multipartFile.getOriginalFilename();
		
		//Add to DB
		HomeBean homeBean= new HomeBean();
		
		homeBean.setDescription(req.getParameter("description"));
		homeBean.setTitle(req.getParameter("title"));
		int HomeId=Integer.parseInt(req.getParameter("HomeId"));
		homeBean.setId(HomeId);
		int SubCategoryId=Integer.parseInt(req.getParameter("selectCategory"));
		homeBean.setSubCategoryId(SubCategoryId);
		
		if(fileName!="")
		//delete the previous image before updating to new
		{
		String imageName=homedao.getImageName(HomeId);
		deleteImage(imageName);
		homeBean.setFileName(fileName);
		}
		
		homedao.updateHomedata(homeBean);
		
		//Save image file
		File imageFile= new File(helpFilePath+File.separator+fileName);
		
		multipartFile.transferTo(imageFile);
		
		return "Success";
	}
	@Override
	public String deleteHomedata(FileUploadForm uploadForm,
			HttpServletRequest req) throws IllegalStateException, IOException {
		
		//Add to DB
		HomeBean homeBean= new HomeBean();
		
		homeBean.setDescription(req.getParameter("description"));
		homeBean.setTitle(req.getParameter("title"));
		int HomeId=Integer.parseInt(req.getParameter("HomeId"));
		homeBean.setId(HomeId);
		int SubCategoryId=Integer.parseInt(req.getParameter("selectCategory"));
		homeBean.setSubCategoryId(SubCategoryId);
		
		String imageName=homedao.getImageName(HomeId);
		deleteImage(imageName);
		
		homedao.deleteHomedata(homeBean);
		
		
	
		return "Success";	}

	@Override
	public List<HomeBean> getHomedata(HttpServletRequest req) {
		int subCategoryId=Integer.parseInt(req.getParameter("selectCategory"));
		if(subCategoryId==1)
		{
			return getHomedata();
		}
		List<Home> homeList=homedao.getHomedata(subCategoryId);
		int size=homeList.size();
		List<HomeBean> homeBeanList= new ArrayList<HomeBean>(); 
		for(Home home:homeList)
		{
			HomeBean bean= new HomeBean();
			bean.setDescription(home.getDescription());
			if(home.getDescription().length()>50)
			bean.setShortDescription(home.getDescription().substring(0, 50));
			else
				bean.setShortDescription(home.getDescription());
			bean.setFileName("/iyc/getImage?fileName="+home.getFileName());
			bean.setTitle(home.getTitle());
			bean.setId(home.getId());
			bean.setSubCategoryId(subCategoryId);
			bean.setSubCategory(home.getSubCategory().getSubcategory());
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			bean.setUpdatedDate(dateFormat.format(home.getUpdatedTime()));
			homeBeanList.add(bean);
		}
		return homeBeanList;
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
	public List<HomeBean> getHomedata() {
		List<Home> homeList=homedao.getAllHomedata();
		
		List<HomeBean> homeBeanList= new ArrayList<HomeBean>();
		
		for(Home home:homeList)
		{
			HomeBean bean= new HomeBean();
			bean.setDescription(home.getDescription());
			if(home.getDescription().length()>50)
				bean.setShortDescription(home.getDescription().substring(0, 50));
				else
					bean.setShortDescription(home.getDescription());
			bean.setFileName("/iyc/getImage?fileName="+home.getFileName());
			bean.setTitle(home.getTitle());
			bean.setId(home.getId());
			bean.setSubCategoryId(home.getSubCategory().getId());
			bean.setSubCategory(home.getSubCategory().getSubcategory());
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			bean.setUpdatedDate(dateFormat.format(home.getUpdatedTime()));
			homeBeanList.add(bean);
		}
		return homeBeanList;
	}
	
	public static void main(String[] args) {
		
		HomeServiceImpl homeServiceImpl= new HomeServiceImpl();
		homeServiceImpl.deleteImage("E:\\images\\iyc\\Image2888.jpg");
		
		String hello="My name is khan";
		System.out.println(hello.substring(0, 9));
	}

}
