package com.iyc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExcelUtil {
	
	/**
	 * Method to set the css for excel header
	 * 
	 * @param workbook
	 * @param sheet
	 * @return
	 */
	public CellStyle csHeader(Workbook workbook, Sheet sheet) {

		CellStyle cs = workbook.createCellStyle();
		cs.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		sheet.setDefaultColumnWidth((short) 15);

		Font font = workbook.createFont();
		font.setFontName("Calibri");
		font.setFontHeightInPoints((short) 12);
		font.setColor(IndexedColors.WHITE.getIndex());

		cs.setFont(font);

		return cs;
	}
	

	
	public static void main(String[] args)
    {
        try
        {
            readExcel();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



	private static void readExcel() throws FileNotFoundException, IOException {
		FileInputStream file = new FileInputStream(new File("C:\\Users\\20065156\\Desktop\\Category_Data.xlsx"));
 
		//FileInputStream file = new FileInputStream(xlfile);
		 
		//Create Workbook instance holding reference to .xlsx file
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
						System.out.print(cell.getStringCellValue() + "t");
						break;
					}
				}
		    }
		    columnCount=0;
		    System.out.println("");
		    }
		}
		file.close();
	}


}
