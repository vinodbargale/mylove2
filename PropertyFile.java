package Properies;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;








public class PropertyFile {

	public static void main(String[] args) throws Throwable {
		Properties p = new Properties();
		
		FileInputStream file=new FileInputStream("C:\\\\Users\\\\DELL\\\\eclipse-workspace\\\\Demo\\\\Properties\\\\OR.properties");
		p.load(file);
	//p.load(new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\Demo\\Properties\\OR.properties"));
		                       //C:\Users\DELL\eclipse-workspace\Demo\OR.properties
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(p.getProperty("Url"));
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(By.xpath(p.getProperty("ObjReset"))));
		driver.findElement(By.xpath(p.getProperty("ObjReset"))).click();
		driver.findElement(By.xpath(p.getProperty("ObjUser"))).sendKeys(p.getProperty("usernamedata"));
		driver.findElement(By.xpath(p.getProperty("Objpass"))).sendKeys(p.getProperty("passworddata"));
		driver.findElement(By.xpath(p.getProperty("ObjLogin"))).click();
		driver.quit();
		
	/*	System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("Url"));
		System.setProperty("webdriver.chrome.driver","F://ChromeDriver//chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(co);
		driver.manage().window().maximize();
driver.get(p.getProperty("Url"));*/
	}

}