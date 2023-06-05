package DataBaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TableData {
	
	public static void main(String[] args) throws SQLException {
		Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","8412043143");
		if(con.isClosed()) {
			System.out.println("Data base is not conneceted");
		}
		else {
			System.out.println("Data bse is connected");
		}
		
		Statement var=con.createStatement();
		ResultSet jira=var.executeQuery("SELECT * FROM COLL");
		while(jira.next()){
			String data=jira.getString("STNO");
			System.out.println(data);
		}
	}


}
