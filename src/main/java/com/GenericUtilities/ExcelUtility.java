package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * This method is used for reading the data from excel file
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @return
	 * @throws Throwable
	 * @author Abhishek
	 */
	public String readdataFromExcel(String SheetName , int RowNo,int ColumnNo) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath); 
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		String value = sh.getRow(RowNo).getCell(ColumnNo).getStringCellValue();
		return value;
	}
	/**
	 * This method is used for getting the last row number  from excel file
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 * @author Abhishek
	 */
	public int getLastRowNo(String SheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		return count;
	}
	/**
	 * This method is used for writing the Data Into Excel
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @param data
	 * @throws Throwable
	 * @author Abhishek
	 */
	public void writeDataIntoExcel(String SheetName, int RowNo, int ColumnNo, String data) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		sh.createRow(RowNo).createCell(ColumnNo).setCellValue(data);
		FileOutputStream fout = new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fout);
	}
	/**
	 * This method is used for reading Multiple Data from excel
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String,String > readMultipleData(String SheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		HashMap<String,String >	map=new HashMap<String,String >();
		for(int i=0;i<=count;i++)       
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		return map;
		
		
	}
	public Object[][] readMultipleSetofData(String SheetName) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRow][lastCell];
		for(int i = 0; i<lastRow;i++ )
		{
			for(int j = 0; j<lastCell;j++)
			{
				obj[i] [j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}
	

}
