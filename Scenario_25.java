/*
 * Scenario 25:
 * 1. Navigate to www.amazon.in
 * 2. Search for 'mobile'
 * 3. Select category 'SmartPhones'
 * 4. Sort the result according to - Price: Low to High
 * 5. Click on the lowest priced/ 1st product after sorting
 * 6. Click on "xyz Customer Reviews" link right to star rating of that product
 * 7. Find out and print the number of 5/4/3/2/1 * (stars) the has receive
 * */


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Scenario_25 {
	
	public static void main (String[] args)
	{
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("mobile");
		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.linkText("Smartphones")).click();
		Select dropdown = new Select(driver.findElement(By.id("sort")));
		dropdown.selectByVisibleText("Price: Low to High");
		
		driver.findElement(By.xpath("//*[@data-asin='B00NUT7SU8']/div/div[2]/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='acrCustomerReviewText']")).click();
		
		System.out.println("Here are the total Product ratings");
		
		for(int i=1;i<=5;i++)
		{			
			System.out.print(driver.findElement(By.xpath("//*[@id='productSummary']/tbody/tr/td[1]/div/div[2]/div[" +i+"]/a/div[1]")).getText() + " is recieved ");
			System.out.print(" -- "+ driver.findElement(By.xpath("//*[@id='productSummary']/tbody/tr/td[1]/div/div[2]/div[" +i+"]/a/div[3]")).getText() + "Times for this product");			
			System.out.println();
		}
		
		driver.quit();
	
	}

}
