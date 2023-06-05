package DataBaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test2 {
	
	public static void main(String[] args) throws SQLException, Exception  {
		
		String dburl="jdbc:oracle:thin:@localhost:1521:xe"	;
		String dbun="system";
		String dbpw="8412043143";

		Connection con=DriverManager.getConnection(dburl,dbun,dbpw);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from log");

		while(rs.next()) {
			String un=rs.getString(1);
			String pw=rs.getString(2);
			System.out.println(un);
			System.out.println(pw);
			System.setProperty("webdriver.chrome.driver","F:\\ChromeDriver\\chromedriver.exe" );
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--allow-remote-origins=*");
			WebDriver driver=new ChromeDriver(co);
			driver.navigate().to("http://183.82.103.245/nareshit/login.php");
			driver.findElement(By.name("txtUserName")).sendKeys(un);
			driver.findElement(By.name("txtPassword")).sendKeys(pw);
			Thread.sleep(4000);
			driver.findElement(By.name("Submit")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Logout")).click();
			driver.close();
		}
		rs.close();
		st.close();
		con.close();
			}


}
