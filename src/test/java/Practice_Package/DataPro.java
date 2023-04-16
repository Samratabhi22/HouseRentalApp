package Practice_Package;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.GenericUtilities.IPathConstants;

public class DataPro {
	@DataProvider()
public Object[] [] getDetails()
{
	Object[] [] obj = new Object[2] [2];
	obj[0][0]=101;
	obj[0][1]="Abhishek";
	
	obj[1][0]=102;
	obj[1][1]="Raja";
	return obj;
	
}
	
}
