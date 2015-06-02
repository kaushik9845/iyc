package com.iyc.dao;

import java.util.List;

import com.iyc.entity.Area;


public interface AreaDao {
	
	List<Area> getArea();
	
	String editArea(Area area);
	
	String addArea(Area area);
	
	String deleteArea(Area area);
	
	public boolean exist(Area area);

}
