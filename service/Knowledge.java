package week5.day2.service;

import java.awt.List;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Knowledge extends ProjectService {
@Test
	public  void runknowledge() {
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("knowledge");
		shadow.findElementByXPath("//span[text()='Knowledge']").click();
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//span[@class='btn-text']//parent::button")).click();
		driver.findElement(By.xpath("//button[@id='lookup.kb_knowledge.kb_knowledge_base']")).click();
		Set<String> win = driver.getWindowHandles();
		ArrayList<String> lst=new ArrayList<String>(win);
		driver.switchTo().window(lst.get(1));
		driver.findElement(By.xpath("//a[text()='IT']")).click();
		driver.switchTo().window(lst.get(0));
		WebElement elem1 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(elem1);
		driver.findElement(By.xpath("//button[@id='lookup.kb_knowledge.kb_category']")).click();
		driver.findElement(By.xpath("(//div[@class='list-item arrow']/following-sibling::div)[3]")).click();
		driver.findElement(By.xpath("//span[text()='Java']//parent::div")).click();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();;
		driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']")).sendKeys("test knowledgecase");
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();


	}

}
