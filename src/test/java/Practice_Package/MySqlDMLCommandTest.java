package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class MySqlDMLCommandTest {

	public static void main(String[] args) throws Throwable {
		Connection con = null;
		int result =0;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
			Statement state = con.createStatement();
			String query="insert into trainee values (144,'Nisha',27,963258741,'Queen','queen666@gmail.com','Irritating the King','Heart',null);";
			result=state.executeUpdate(query);
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			if(result==1)
				{System.out.println("data updated");
				
				}
		
		else
		{
			System.err.println("data not updated");
		}
			con.close();
	}

	}

}
