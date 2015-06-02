package com.iyc.dao;

import java.util.List;

import com.iyc.bean.InfoBean;
import com.iyc.entity.Info;


public interface InfoDao {
	
	String addInfodata(InfoBean Info);
	
	String updateInfodata(InfoBean Info);
	
	String deleteInfodata(InfoBean Info);
	
	List<Info> getInfodata(int subCategoryId);
	
	List<Info> getAllInfodata();
	
	String getImageName(int InfoId);

}
