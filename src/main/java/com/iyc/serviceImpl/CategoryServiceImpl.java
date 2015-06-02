package com.iyc.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

import com.iyc.dao.CategoryDao;
import com.iyc.entity.Category;
import com.iyc.service.CategoryService;
import com.iyc.util.ExcelUtil;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao   categoryDao;
	
	@Autowired
	ExcelUtil excelutil;
	
	@Override
	public JSONArray getCategory() {
		List<Category> list=categoryDao.getCategory();
		int size=list.size();
		JSONArray arr= new JSONArray();
		int serial=1;
		for(Category cat:list)
		{
			JSONObject obj= new JSONObject();
			obj.put("id", cat.getId());
			obj.put("category", cat.getCategory());
			obj.put("serialNo", serial++);
			
			arr.add(obj);
		}
		return arr;
	}

	@Override
	public String editCategory(Category category) {
		
		return categoryDao.editCategory(category);
	}
	
	@Override
	public String addCategory(Category category) {
		
		return categoryDao.addCategory(category);
	}
	
	@Override
	public String deleteCategory(Category category) {
		
		return categoryDao.deleteCategory(category);
	}

	@Override
	public void getCategoryTemplate(HttpServletRequest req,
			HttpServletResponse response, HttpSession session) throws IOException {

		Workbook[] wbs = new Workbook[] { new XSSFWorkbook(),
				new XSSFWorkbook() };
		Workbook workbook = wbs[0];
		Sheet sheet = workbook.createSheet("Category Data");
		CellStyle cs = excelutil.csHeader(workbook, sheet);
		
			
		Cell cell = null;
		int rownum = 0;
		Row row = null;
		row = sheet.createRow(rownum);
		cell = row.createCell(0);
		cell.setCellValue("Serial Number");
		cell.setCellStyle(cs);
		cell = row.createCell(1);
		cell.setCellValue("Category");
		cell.setCellStyle(cs);
		
		String filename = "Category_Data.xls";
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
	
	
	public  void readExcel(MultipartFile file1) throws FileNotFoundException, IOException {
		
		File xlfile= new File("Category.xlsx");
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
		    Category category= new Category();
		    if(rowCount++!=0)
		    {
		    //For each row, iterate through all the columns
		    Iterator<Cell> cellIterator = row.cellIterator();
		     
		    while (cellIterator.hasNext())
		    {
		        Cell cell = cellIterator.next();
		       
		        if (columnCount++<2) {
		        	
					//Check the cell type and format accordingly
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "t");
						break;
					case Cell.CELL_TYPE_STRING:
						category.setCategory(cell.getStringCellValue());
						break;
					}
				}
		    }
		    if(!categoryDao.exist(category))
		    categoryDao.addCategory(category);
		    columnCount=0;
		    System.out.println("");
		    }
		}
		file.close();
	}
	}



