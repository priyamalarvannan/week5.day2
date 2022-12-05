package week5.day2.service;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class NewProposal extends ProjectService{
@Test
	public void runnewproposal() throws InterruptedException {
	
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("proposal",Keys.ENTER);
		shadow.findElementByXPath("//span[text()='My Proposals']").click();
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(eleFrame);
		//finding the row size before element added
		List<WebElement> row1 = driver.findElements(By.xpath("//tbody[@class='list2_body']//tr"));
		System.out.println("Total number of rows are "+row1.size());
	//	4. Click- new  and  fill mandatory fields and click 'Submit' button.
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']")).sendKeys("Proposal test112334");
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
		//finding the row size after element added
		List<WebElement> row2 = driver.findElements(By.xpath("//tbody[@class='list2_body']//tr"));
		System.out.println("the list of row"+row2.size());
		
		if((row1.size()+1)==row2.size())
		{
			System.out.println("proposal added");
		}
		else
		{
			System.out.println("proposal not added");
		}
		
	}

}
