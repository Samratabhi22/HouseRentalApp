package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelTest {

	public static void main(String[] args) throws Throwable {
		//create object for excel file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Readexcel.xlsx");
		//get Workbook
		Workbook wb = WorkbookFactory.create(fis);
		//get the sheet
		Sheet sh = wb.getSheet("Sheet1");
		//get row
		Row row = sh.getRow(1);
		//get cell
		Cell cel = row.getCell(0);
		//get the value
		String value = cel.getStringCellValue();
		System.out.println(value);
		
		
		
		

	}

}
