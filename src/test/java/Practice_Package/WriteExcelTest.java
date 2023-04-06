package Practice_Package;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteExcelTest {

	public static void main(String[] args) throws Throwable {
		//create object for physical file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Readexcel.xlsx");
		//get workbook
		Workbook wb = WorkbookFactory.create(fis);
		//get the sheet
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(4);
		Cell cel = row.getCell(0);
		cel.setCellValue("pyspiders");
		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\Readexcel.xlsx");
		wb.write(fout);
		wb.close();

	}

}
