package com.iyc.dao;

import java.util.List;

import com.iyc.bean.DirectorySearchbean;
import com.iyc.bean.Directorybean;
import com.iyc.entity.Directory;


public interface DirectoryDao {
	
	List<Directory> getDirectory();
	
	List<Directory> getDirectorySearch(DirectorySearchbean directorySearchbean);
	
	String editDirectory(Directorybean directory);
	
	String addDirectory(Directorybean directory);
	
	String deleteDirectory(Directorybean directory);

	void addDirectoryExcel(Directorybean directory);
	
	

}
