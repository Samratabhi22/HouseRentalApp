
package com.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
Connection con = null;
/**
 * This method is used for connection to database
 * @throws Throwable
 * @author Abhishek
 */
public void connectToDb() throws Throwable 
{
	Driver driver = new Driver ();
	DriverManager.registerDriver(driver);
	con= DriverManager.getConnection(IPathConstants.DBURL, IPathConstants.DBUSERNAME, IPathConstants.DBPASSWORD);
	
}
/**
 * This method is used for executing the query
 * @param query
 * @param expData
 * @param columnIndex
 * @return
 * @throws Throwable
 * @author Abhishek
 */
public String executeQueryAndGetData(String query, String expData, int columnIndex) throws Throwable
{
	ResultSet result = con.createStatement().executeQuery(query);
	boolean flag = false;
	while(result.next())
	{
		String data = result.getString(columnIndex);
		
		if(data.equalsIgnoreCase(expData))
		{
			flag= true;
			break;
		}	
		}
		if(flag)
		{
			System.out.println("data is verified");
			return expData;
		}
		else
		{
			System.out.println("data is not verified");
			return "";
		}
	}
/**
 * This method is used for closing the datatbase 
 * @throws Throwable
 * @author Abhishek
 */
	public void closeDB() throws Throwable
	{
		con.close();
		System.out.println("Database connection closed");
	}

}

