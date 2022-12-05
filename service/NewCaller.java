package week5.day2.service;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class NewCaller extends ProjectService {
	@Test

	public  void runnewcaller() throws InterruptedException {
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("callers");
		shadow.findElementByXPath("//mark[text()='Callers']").click();	
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		driver.findElement(By.id("sys_user.first_name")).sendKeys("priya");
		driver.findElement(By.id("sys_user.last_name")).sendKeys("Malarvannan");
		driver.findElement(By.id("sys_user.title")).sendKeys("System developer");
		driver.findElement(By.id("sys_user.email")).sendKeys("priyamalarvannan1@gmail.com");
		driver.findElement(By.id("sys_user.phone")).sendKeys("80953");
		driver.findElement(By.id("sys_user.mobile_phone")).sendKeys("9611");
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		Thread.sleep(1000);
		//5. Search and verify the newly created Caller
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys("priya",Keys.ENTER);
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[3]")).sendKeys("priya",Keys.ENTER);
		String fname = driver.findElement(By.xpath("(//td[@class='vt'])[2]")).getText();
		System.out.println(fname);
		if(fname.equals("priya"))
		{
			System.out.println("New caller is added");
		}
		else
		{
			System.out.println("New caller is not added.");
		}

	}

}
