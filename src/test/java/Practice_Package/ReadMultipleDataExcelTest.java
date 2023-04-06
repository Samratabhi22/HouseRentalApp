package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataExcelTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Readexcel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int count = sh.getLastRowNum();
		System.out.println(count);
		for (int i = 1; i <=count; i++) 
		{
			String orgsn = sh.getRow(i).getCell(0).getStringCellValue();
			
			String loc = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(orgsn+"  "+loc);
		}
		

	}

}
