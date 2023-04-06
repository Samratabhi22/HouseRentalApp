package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.GenericUtilities.IPathConstants;

public class DataproviderExcelData {
public Object[] [] data() throws Throwable 
{
	FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("DP");
	int lastRow = sh.getLastRowNum()+1;
int lastCell = sh.getRow(0).getLastCellNum();
	Object[] [] obj = new Object[lastRow][lastCell];
	for(int i=0;i<lastRow;i++)
		
	{
		for(int j=0;j<lastCell;j++)
		{
			obj[i][j]=sh.getRow(j).getCell(j).getStringCellValue();
		}
	}
	return obj;
}
}
