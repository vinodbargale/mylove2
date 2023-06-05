package DataBaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test1 {
	
	
	public static void main(String[] args) throws Exception {
		
		String dburl="jdbc:mysql://localhost:3306"	;
		String dbur="root";
		String dbpw="8412043143";
		
		
		
		Connection conn =DriverManager.getConnection(dburl,dbur,dbpw);
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("Select * from log" );
			
			while(rs.next()){
				String un=rs.getString(1);
				String pw=rs.getString(2);
				System.out.println(un);
				System.out.println(pw);
				
				System.setProperty("webdriver.gecko.driver","F:\\gekodriver\\geckodriver.exe" );
				WebDriver driver=new FirefoxDriver();
				driver.navigate().to("http://183.82.103.245/nareshit/login.php");
				
				
		/*spring.datasource.url= jdbc:mysql://localhost:3306/file_demo?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
			spring.datasource.username= root
			spring.datasource.password= callicoder*/
			
				
				
				
			}
			
			
			
		}

}
