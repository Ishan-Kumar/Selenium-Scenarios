/*
 * Scenario 5: - 
 * 1. Load : "http://postimage.org/" and verify page title.
 * 2. Upload a photo (Browse photo, Select type of Image Content, Click 'Upload It!' button).
 * 3. Verify Image has uploaded successfully
 * 
 * */


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Scenario_5 {
	static WebDriver driver = new FirefoxDriver();
	
	public static void main(String[] args){
		Scenario_5 obj = new Scenario_5();
		obj.scenes();
			
	}
	
	void scenes(){
		//--------------------Scene 1---------------
		driver.get("http://postimage.org");
		System.out.println("Page Title of the Site is: " + driver.getTitle());
		
		//--------------------Scene 2---------------
		driver.findElement(By.xpath("//*[@id='myForm']/table/tbody/tr[2]/td[2]/div/input")).sendKeys("/Users/ishan/Desktop/TestAuto/images.jpg");
		driver.findElement(By.xpath("//*[@id ='optsize']/option[@value='2']")).click();
		driver.findElement(By.xpath("//*[@id='l_adult_no']")).click();
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("btSubmit", "");
		
		driver.manage().timeouts().implicitlyWait(7000L, TimeUnit.SECONDS);		
		System.out.println("Get Text is:" + driver.findElement(By.xpath("html/body/center/p[1]")).getText());				
		driver.close();
		
	}
}
