package week5.day2.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
public class OrderingMobile extends ProjectService {
@Test
public void runOrderMobile() throws InterruptedException {
	
{
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Service Catalog");
	
		shadow.findElementByXPath("//span[text()='Service Catalog']").click();

		/* To Locate frame inside Shadow DOM  by XPath and save as WebElement*/
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(eleFrame);
		//4. Click on  mobiles
		driver.findElement(By.linkText("Mobiles")).click();
		//5.Select Apple iphone6s
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 13 pro']")).click();
		//6.Update color field to rose gold and storage field to 128GB
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("how many windows open" +windowHandles.size());
		//convert set into list
		List<String> lstwindow=new ArrayList<String>(windowHandles);
		//move the control into the second window
		driver.switchTo().window(lstwindow.get(0));
		System.out.println(driver.getWindowHandle());
		Shadow shadow1=new Shadow(driver); 
		shadow1.setImplicitWait(10);		
		WebElement frame2 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@value='silver']//parent::span")).click();
		driver.findElement(By.xpath("//label[text()='No']")).click();
		/*WebElement drop = driver.findElement(By.id("dropdown1"));
					Select o1=new Select(drop);
					o1.selectByIndex(2);*/
		WebElement drop = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select obj=new Select(drop);
		obj.selectByIndex(1);
		driver.findElement(By.xpath("//label[text()='128 GB']")).click();
		//	7.Select  Order now option
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		//	8.Verify order is placed and copy the request number"*/
		String text = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
		System.out.println("The request num"+text);
		String text2 = driver.findElement(By.xpath("//div[@class='notification notification-success']/span")).getText();
		System.out.println(text2);
		if(text2.contains("submitted"))
		{
			System.out.println("order placed"); 
			
		}
		else
		{
			System.out.println("order is not placed");
		}
		
		

	}
	
	
}
}
