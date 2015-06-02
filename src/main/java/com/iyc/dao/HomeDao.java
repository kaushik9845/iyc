package com.iyc.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iyc.bean.HomeBean;
import com.iyc.entity.Home;


public interface HomeDao {
	
	String addHomedata(HomeBean home);
	
	String updateHomedata(HomeBean home);
	
	String deleteHomedata(HomeBean home);
	
	List<Home> getHomedata(int subCategoryId);
	
	List<Home> getAllHomedata();
	
	String getImageName(int homeId);
	
	int getWebSiteCount(HttpServletRequest req);

}
