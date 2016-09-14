/*
 * Scenario 9:
 * URL:  http://www.html5rocks.com/en/tutorials/forms/html5forms/input-types.html 
 * 1. Go to URL in IE
 * 2. Fill all information except birthday
 * 3. Click on “Cross Bridge”
 * */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Scenario_9 
{
	public static void main(String[] args){	
	WebDriver driver = new FirefoxDriver();
	
	//-----------------------Scene 1-----------------
	driver.get("http://www.html5rocks.com/en/tutorials/forms/html5forms/input-types.html");
	//-----------------------Scene 2-----------------
	driver.findElement(By.xpath("//*[@id='first_last']")).sendKeys("Test1");
	driver.findElement(By.xpath("//*[@id='email_addr']")).sendKeys("awsome.testing@gmail.com");
	driver.findElement(By.xpath("//*[@id='email_addr_confirm']")).sendKeys("awsome.testing@gmail.com");
	driver.findElement(By.xpath("//*[@id='fav_website']")).sendKeys("http://pocketnow.com/");
	driver.findElement(By.xpath("//*[@id='fav_pizza']")).sendKeys("+91 1234567890");
	driver.findElement(By.xpath("//*[@id='dob']")).sendKeys("02/ 01/ 1989");
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.getElementById('color').value='#3F4FC4'");
	driver.findElement(By.xpath("//*[@id='chocolate']")).sendKeys("Dark Choclate");
	driver.findElement(By.xpath("//*[@id='part_number']")).sendKeys("HSC0424PP");
	js.executeScript("document.getElementById('airspeed_velocity').value='30'");
	driver.findElement(By.xpath("html/body/div[1]/form/button")).click();		
	driver.quit();
	}

}
