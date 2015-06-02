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

import com.iyc.bean.SubCategorybean;
import com.iyc.dao.SubCategoryDao;
import com.iyc.entity.SubCategory;
import com.iyc.service.SubCategoryService;
import com.iyc.util.ExcelUtil;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

	@Autowired
	SubCategoryDao   subCategoryDao;
	
	@Autowired
	ExcelUtil excelutil;
	
	@Override
	public JSONArray getSubCategory() {
		List<SubCategory> list=subCategoryDao.getSubCategory();
		int size=list.size();
		JSONArray arr= new JSONArray();
		int serial=1;
		for(SubCategory cat:list)
		{
			JSONObject obj= new JSONObject();
			obj.put("id", cat.getId());
			obj.put("subCategory", cat.getSubcategory());
			obj.put("category", cat.getCategory().getCategory());
			obj.put("categoryId", cat.getCategory().getId());
			obj.put("serialNo", serial++);
			
			arr.add(obj);
		}
		return arr;
	}

	@Override
	public String editSubCategory(SubCategorybean subCategory) {
		
		return subCategoryDao.editSubCategory(subCategory);
	}
	
	@Override
	public String addSubCategory(SubCategorybean subCategory) {
		
		return subCategoryDao.addSubCategory(subCategory);
	}
	
	@Override
	public String deleteSubCategory(SubCategorybean subCategory) {
		
		return subCategoryDao.deleteSubCategory(subCategory);
	}

	@Override
	public void getSubCategoryTemplate(HttpServletRequest req,
			HttpServletResponse response, HttpSession session) throws IOException {

		Workbook[] wbs = new Workbook[] { new XSSFWorkbook(),
				new XSSFWorkbook() };
		Workbook workbook = wbs[0];
		Sheet sheet = workbook.createSheet("SubCategory_Data");
		CellStyle cs = excelutil.csHeader(workbook, sheet);
		
			
		Cell cell = null;
		Row row = null;
		row = sheet.createRow(0);
		cell = row.createCell(0);
		cell.setCellValue("Serial Number");
		cell.setCellStyle(cs);
		
		cell = row.createCell(1);
		cell.setCellValue("Category");
		cell.setCellStyle(cs);
		
		cell = row.createCell(2);
		cell.setCellValue("Sub Category");
		cell.setCellStyle(cs);
		
		String filename = "SubCategory_Data.xls";
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
		
		File xlfile= new File("SubCategory.xlsx");
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
		    SubCategorybean subCategory= new SubCategorybean();
		    if(rowCount++!=0)
		    {
		    //For each row, iterate through all the columns
		    Iterator<Cell> cellIterator = row.cellIterator();
		     
		    while (cellIterator.hasNext())
		    {
		        Cell cell = cellIterator.next();
		       
		        if (columnCount++<3) {
		        	
					//Check the cell type and format accordingly
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "t");
						break;
					case Cell.CELL_TYPE_STRING:
						{
							if(columnCount==2)
								subCategory.setCategoryId(subCategoryDao.getIdfromName(cell.getStringCellValue()));
							else								
							subCategory.setSubCategory(cell.getStringCellValue());
						
						break;
						}
					}
				}
		    }
		    
		    if(!subCategoryDao.exist(subCategory) && subCategory.getCategoryId()!=0)
		    subCategoryDao.addSubCategory(subCategory);
		    columnCount=0;
		    System.out.println("");
		    }
		}
		file.close();
	}
	}



