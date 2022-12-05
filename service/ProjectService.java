package week5.day2.service;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ProjectService {
	ChromeDriver driver;
	Shadow shadow;
	@Parameters({"url","username","password"})
	
	@BeforeMethod
		public  void LaunchBrowser(String url,String uname,String pwrd) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("user_name")).sendKeys(uname);
		driver.findElement(By.id("user_password")).sendKeys(pwrd);
		driver.findElement(By.id("sysverb_login")).click();
		
		shadow=new Shadow(driver);
		shadow.setImplicitWait(30);
		shadow.findElementByXPath("//div[text()='All']").click();

		}
	@AfterMethod
	public void postcondition()
	{
		driver.close();
	}
}
	

