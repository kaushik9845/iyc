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
import com.iyc.bean.InfoBean;
import com.iyc.dao.InfoDao;
import com.iyc.entity.Info;
import com.iyc.service.InfoService;

@Service
public class InfoServiceImpl implements InfoService {


	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	InfoDao Infodao;
	
	@Override
	public String addInfodata(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletRequest req) throws IllegalStateException, IOException {
		
		
		String helpFilePath = messageSource.getMessage("image.path",
				new Object[] {}, null);
		
		MultipartFile multipartFile=uploadForm.getFiles().get(0);
		
		String fileName=multipartFile.getOriginalFilename();
		
		//Add to DB
		InfoBean InfoBean= new InfoBean();
		InfoBean.setFileName(fileName);
		InfoBean.setDescription(req.getParameter("description"));
		InfoBean.setTitle(req.getParameter("title"));
		InfoBean.setId(0);
		int SubCategoryId=Integer.parseInt(req.getParameter("selectCategory"));
		InfoBean.setSubCategoryId(SubCategoryId);
		
		Infodao.addInfodata(InfoBean);
		
		//Save image file
		File imageFile= new File(helpFilePath+File.separator+fileName);
		
		multipartFile.transferTo(imageFile);
		
		return "Success";
	}
	
	

	@Override
	public String updateInfodata(FileUploadForm uploadForm,
			HttpServletRequest req) throws IllegalStateException, IOException {
		String helpFilePath = messageSource.getMessage("image.path",
				new Object[] {}, null);
		
		MultipartFile multipartFile=uploadForm.getFiles().get(0);
		
		String fileName=multipartFile.getOriginalFilename();
		
		//Add to DB
		InfoBean InfoBean= new InfoBean();
		
		InfoBean.setDescription(req.getParameter("description"));
		InfoBean.setTitle(req.getParameter("title"));
		int InfoId=Integer.parseInt(req.getParameter("InfoId"));
		InfoBean.setId(InfoId);
		int SubCategoryId=Integer.parseInt(req.getParameter("selectCategory"));
		InfoBean.setSubCategoryId(SubCategoryId);
		
		if(fileName!="")
		//delete the previous image before updating to new
		{
		String imageName=Infodao.getImageName(InfoId);
		deleteImage(imageName);
		InfoBean.setFileName(fileName);
		}
		
		Infodao.updateInfodata(InfoBean);
		
		//Save image file
		File imageFile= new File(helpFilePath+File.separator+fileName);
		
		multipartFile.transferTo(imageFile);
		
		return "Success";
	}
	@Override
	public String deleteInfodata(FileUploadForm uploadForm,
			HttpServletRequest req) throws IllegalStateException, IOException {
		
		//Add to DB
		InfoBean InfoBean= new InfoBean();
		
		InfoBean.setDescription(req.getParameter("description"));
		InfoBean.setTitle(req.getParameter("title"));
		int InfoId=Integer.parseInt(req.getParameter("InfoId"));
		InfoBean.setId(InfoId);
		int SubCategoryId=Integer.parseInt(req.getParameter("selectCategory"));
		InfoBean.setSubCategoryId(SubCategoryId);
		
		String imageName=Infodao.getImageName(InfoId);
		deleteImage(imageName);
		
		Infodao.deleteInfodata(InfoBean);
		
		
	
		return "Success";	}

	@Override
	public List<InfoBean> getInfodata(HttpServletRequest req) {
		int subCategoryId=Integer.parseInt(req.getParameter("selectCategory"));
		if(subCategoryId==30)
		{
			return getInfodata();
		}
		List<Info> InfoList=Infodao.getInfodata(subCategoryId);
		int size=InfoList.size();
		List<InfoBean> InfoBeanList= new ArrayList<InfoBean>(); 
		for(Info Info:InfoList)
		{
			InfoBean bean= new InfoBean();
			bean.setDescription(Info.getDescription());
			if(Info.getDescription().length()>50)
				bean.setShortDescription(Info.getDescription().substring(0, 50));
				else
					bean.setShortDescription(Info.getDescription());
			bean.setFileName("/iyc/getImage?fileName="+Info.getFileName());
			bean.setTitle(Info.getTitle());
			bean.setId(Info.getId());
			bean.setSubCategoryId(subCategoryId);
			bean.setSubCategory(Info.getSubCategory().getSubcategory());
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			bean.setUpdatedDate(dateFormat.format(Info.getUpdatedTime()));
			InfoBeanList.add(bean);
		}
		return InfoBeanList;
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
	public List<InfoBean> getInfodata() {
		List<Info> InfoList=Infodao.getAllInfodata();
		int size=InfoList.size();
		List<InfoBean> InfoBeanList= new ArrayList<InfoBean>(); 
		for(Info Info:InfoList)
		{
			InfoBean bean= new InfoBean();
			bean.setDescription(Info.getDescription());
			if(Info.getDescription().length()>50)
				bean.setShortDescription(Info.getDescription().substring(0, 50));
				else
					bean.setShortDescription(Info.getDescription());
			bean.setFileName("/iyc/getImage?fileName="+Info.getFileName());
			bean.setTitle(Info.getTitle());
			bean.setId(Info.getId());
			bean.setSubCategoryId(Info.getSubCategory().getId());
			bean.setSubCategory(Info.getSubCategory().getSubcategory());
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			bean.setUpdatedDate(dateFormat.format(Info.getUpdatedTime()));
			InfoBeanList.add(bean);
		}
		return InfoBeanList;
	}
	
	public static void main(String[] args) {
		
		InfoServiceImpl InfoServiceImpl= new InfoServiceImpl();
		InfoServiceImpl.deleteImage("E:\\images\\iyc\\Image2888.jpg");
	}

}
