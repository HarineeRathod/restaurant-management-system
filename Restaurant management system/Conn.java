package restaurant;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	static Connection con;
	
	public  static Connection create() {
		
		try {
			// load the driver
			//Class.forName("com.mysql.jdbc.Driver");
			
			// creating the connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","Manav91101");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}

}
