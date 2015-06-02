package com.iyc.dao;

import java.util.List;

import com.iyc.bean.EventBean;
import com.iyc.entity.Event;


public interface EventDao {
	
	String addEventdata(EventBean Event);
	
	String updateEventdata(EventBean Event);
	
	String deleteEventdata(EventBean Event);
	
	List<Event> getEventdata(int subCategoryId);
	
	List<Event> getAllEventdata();
	
	String getImageName(int EventId);

}
