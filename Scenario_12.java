/*
 * Scenario 12:
 * URL: http://www.htmlcodetutorial.com/frames/_IFRAME.html
 * 1. Go URL
 * 2. There is one text area
 * 3. Select text of first line
 * Expected result: IFRAME example
 * */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Scenario_12 {

public static void main(String args[]) throws Exception{
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.htmlcodetutorial.com/frames/_IFRAME.html");
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@src='hello.html']")));
		System.out.println(driver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr/td/h3")).getText());
		driver.close();
}
	
}
