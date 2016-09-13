/*
 * 1. Load : "http://www.timeanddate.com/worldclock/india/new-delhi/" and verify page title.
 * 2. Verify correct date displayed on the page 
 * */


import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Scenario_1 {

	public static void main(String[] args)
	{

		WebDriver driver = new FirefoxDriver();
		//--------------------Scene 1---------------
		driver.get("http://www.timeanddate.com/worldclock/india/new-delhi/");
		System.out.println("Page Title of the Site is: " + driver.getTitle());

		//--------------------Scene 2---------------
		String sDate = driver.findElement(By.xpath("//*[@id='ctdat']")).getText(); 		//----Locate gps date
		System.out.println( "Website date is: " + sDate);	

		SimpleDateFormat sdf = new SimpleDateFormat("EEEEEE, d MMMMM yyyy");    		//---Align the format of the System date into desired GPS format, "http://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html"
		String Sdate = sdf.format(new Date());											//----Assign and store the format in string			
		System.out.println("System date is: " + Sdate);

		if(sDate.equalsIgnoreCase(Sdate))												//------Compare Both Dates
		{														
			System.out.println("Date om the site is correct");
		}else 
			System.out.println("Date on the website is not correct");
		driver.quit();
	}

}
