package com.iyc.dao;

import java.util.List;

import com.iyc.entity.Services;


public interface ServicesDao {
	
	List<Services> getServices();
	
	String editServices(Services service);
	
	String addServices(Services service);
	
	String deleteServices(Services service);
	
	public boolean exist(Services service);

}
