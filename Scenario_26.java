/*
 * Scenario 26:
 * 1. Login to Facebook.
 * 2. Print how many friends are there in the friend list.
 * 3. Print all the friends in your friend list.
 * */


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Scenario_26 {
	public static void main(String args[])
	{
		WebDriver driver =  new FirefoxDriver();
		
		//Login Facebook
		driver.get("https://www.facebook.com/?_rdr");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("uremail");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("urpassword");		
		
		driver.findElement(By.xpath("//*[@id='loginbutton']")).click();
		
		//Navigate to Friends 
		driver.findElement(By.xpath("//*/a[@title='Profile']/span")).click();
		driver.findElement(By.xpath("//a[@data-tab-key='friends']")).click();
		
		//Count & Print
		int friendsNum = Integer.parseInt(driver.findElement(By.xpath("//a[@name='All Friends']/span[@class='_3d0']")).getText());
		System.out.println("There are total " + friendsNum + " Friends, here is the list");
				
		for(int i=0; i<friendsNum; i++)
		{
			
			System.out.println(driver.findElements(By.xpath("//div[@class='fsl fwb fcb']")).get(i).getText());
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", "");
		}		
	}
	

}
