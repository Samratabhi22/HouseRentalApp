package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabaseTest {

	public static void main(String[] args) throws Throwable {
		Connection con=null;
		
		try {
			//create object for driver
			Driver driver = new Driver();
			//1.Register the user
			DriverManager.registerDriver(driver);
			//2.Get connection for the database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
			//3.create statement
			Statement state = con.createStatement();
			String query="select * from trainee;";
			//4.execute query 
	 ResultSet result = state.executeQuery(query);
	 while(result.next())
	 {
		 System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getString(6)+" "+result.getString(7)+" "+result.getString(8));
	 }
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{//5.close database connection
			con.close();
		}

	}
	
	
	
	
	

	
}
