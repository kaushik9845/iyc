package com.iyc.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iyc.bean.DirectorySearchbean;
import com.iyc.bean.Directorybean;
import com.iyc.dao.DirectoryDao;
import com.iyc.entity.Directory;
import com.iyc.service.DirectoryService;
import com.iyc.util.ExcelUtil;

@Service
public class DirectoryServiceImpl implements DirectoryService {

	@Autowired
	DirectoryDao   directoryDao;
	
	@Autowired
	ExcelUtil excelutil;
	
	@Override
	public JSONArray getDirectory() {
		List<Directory> list=directoryDao.getDirectory();
		int size=list.size();
		JSONArray arr= new JSONArray();
		int serial=1;
		for(Directory dir:list)
		{
			JSONObject obj= new JSONObject();
			obj.put("serialNo", serial++);
			obj.put("id", dir.getId());
			obj.put("description", dir.getDescription());
			if(dir.getDescription().length()>50)
			obj.put("shortDescription", dir.getDescription().substring(0, 50));
			else
			obj.put("shortDescription", dir.getDescription());
			obj.put("important", dir.getImportant());
			obj.put("serviceName", dir.getService().getServiceName());
			obj.put("serviceId", dir.getService().getId());
			obj.put("areaName", dir.getArea().getAreaName());
			obj.put("areaId", dir.getArea().getId());
			obj.put("name", dir.getName());
			obj.put("mobile", dir.getMobile());
			
			arr.add(obj);
		}
		return arr;
	}
	
	@Override
	public JSONArray getDirectorySearch(DirectorySearchbean directorySearchbean) {
				
		
		List<Directory> list=directoryDao.getDirectorySearch(directorySearchbean);
		
		JSONArray arr= new JSONArray();
		int serial=1;
		for(Directory dir:list)
		{
			JSONObject obj= new JSONObject();
			obj.put("serialNo", serial++);
			obj.put("id", dir.getId());
			obj.put("description", dir.getDescription());
			
			if(dir.getDescription().length()>50)
				obj.put("shortDescription", dir.getDescription().substring(0, 50));
				else
				obj.put("shortDescription", dir.getDescription());
			
			obj.put("important", dir.getImportant());
			obj.put("serviceName", dir.getService().getServiceName());
			obj.put("serviceId", dir.getService().getId());
			obj.put("areaName", dir.getArea().getAreaName());
			obj.put("areaId", dir.getArea().getId());
			obj.put("name", dir.getName());
			obj.put("mobile", dir.getMobile());
			
			arr.add(obj);
		}
		return arr;
	}

	@Override
	public String editDirectory(Directorybean directory) {
		
		return directoryDao.editDirectory(directory);
	}
	
	@Override
	public String addDirectory(Directorybean directory) {
		
		return directoryDao.addDirectory(directory);
	}
	
	@Override
	public String deleteDirectory(Directorybean directory) {
		
		return directoryDao.deleteDirectory(directory);
	}

	@Override
	public void getDirectoryTemplate(HttpServletRequest req,
			HttpServletResponse response, HttpSession session) throws IOException {

		Workbook[] wbs = new Workbook[] { new XSSFWorkbook(),
				new XSSFWorkbook() };
		Workbook workbook = wbs[0];
		Sheet sheet = workbook.createSheet("Directory Data");
		
		CellStyle cs = excelutil.csHeader(workbook, sheet);
		
			
		createCellHeaders(sheet, cs);
		
		String filename = "Directory_Data.xls";
		if (workbook instanceof XSSFWorkbook) {
			filename = filename + "x";
		}
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename="
				+ filename);
		ServletOutputStream out = response.getOutputStream();
		workbook.write(out);
		out.close();
		
	}

	private void createCellHeaders(Sheet sheet, CellStyle cs) {
		Cell cell = null;
		int rownum = 0;
		Row row = null;
		row = sheet.createRow(rownum);
		
		cell = row.createCell(0);
		cell.setCellValue("Serial Number");
		cell.setCellStyle(cs);
		
		cell = row.createCell(1);
		cell.setCellValue("Name");
		cell.setCellStyle(cs);
		
		cell = row.createCell(2);
		cell.setCellValue("Service");
		cell.setCellStyle(cs);
		
		cell = row.createCell(3);
		cell.setCellValue("Area");
		cell.setCellStyle(cs);
		
		cell = row.createCell(4);
		cell.setCellValue("Mobile");
		cell.setCellStyle(cs);
		
		cell = row.createCell(5);
		cell.setCellValue("Description");
		cell.setCellStyle(cs);
		
		cell = row.createCell(6);
		cell.setCellValue("Important");
		cell.setCellStyle(cs);
		
	}
	
	
	public  void readExcel(MultipartFile file1) throws FileNotFoundException, IOException {
		
		File xlfile= new File("Directory.xlsx");
		file1.transferTo(xlfile);
		
		FileInputStream file = new FileInputStream(xlfile);
 
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		 
		//Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);
 
		//Iterate through each rows one by one
		Iterator<Row> rowIterator = sheet.iterator();
		
		int rowCount=0;
		int columnCount=0;
		while (rowIterator.hasNext())
		{
		    Row row = rowIterator.next();
		    Directorybean directory= new Directorybean();
		    if(rowCount++!=0)
		    {
		    //For each row, iterate through all the columns
		    Iterator<Cell> cellIterator = row.cellIterator();
		     
		    while (cellIterator.hasNext())
		    {
		        Cell cell = cellIterator.next();
		       
		        if (columnCount<7) {
		        	switch(columnCount)
		        	{
		        	case 1:directory.setName(cell.getStringCellValue());break;
		        	case 2:directory.setServiceName(cell.getStringCellValue());break;
		        	case 3:directory.setAreaName(cell.getStringCellValue());break;
		        	case 4:{
		        		long val=(long) cell.getNumericCellValue();
		        		System.out.println(val);
		        		BigInteger bigint=BigInteger.valueOf(val);
		        		directory.setMobile(bigint);break;
		        	}
		        	case 5:directory.setDescription(cell.getStringCellValue());break;
		        	case 6:{
		        		if(cell.getStringCellValue().equalsIgnoreCase("Important"))
		        		directory.setImportant(1);
		        		else directory.setImportant(0);
		        			break;
		        		
		        	}
		        	
		        	}
		        	columnCount++;
				}
		    }
		    
		    directoryDao.addDirectoryExcel(directory);
		    columnCount=0;
		    System.out.println("");
		    }
		}
		file.close();
	}

	
	}



