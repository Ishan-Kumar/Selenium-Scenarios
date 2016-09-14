/*
 * Scenario 22:
 * 1. Navigate to www.flipkart.com , Mouse hover on "Electronics" -->  mouse hover on "Brands"--> click on "Canon" from cameras.
 * 2. Add first 3 cameras from the result list to comparison list - "Add to compare" , by clicking on the check box below the product	
 * 3. Click on "Compare" button
 * 4. Find the best product using the below logic:
 *  i. Should be in stock
 *  ii. Price should be lowest among in stock cameras in the comparison list
 *  print the resulting product name , cost and expected delivery time.
 *  5. Click on 'Yes' in the question - "was it useful"
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class Scenario_22 
{
	
	public static WebDriver driver = new FirefoxDriver();
	public static JavascriptExecutor js =  (JavascriptExecutor) driver;
	
	public static void main (String args[]) throws Exception
	{
		Scenario_22 obj1 = new Scenario_22();
		obj1.searchAndCompare();
		driver.quit();
	}


	void searchAndCompare() throws Exception
	{
		driver.get("http://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000L);
		
		//----------------------Navigate to canon--------------
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@data-key='electronics']"))).build().perform();
		Thread.sleep(1000L);
		act.moveToElement(driver.findElement(By.xpath("//li[@id='menu-electronics-tab-1']"))).build().perform();
		Thread.sleep(1000L);
		act.moveToElement(driver.findElement(By.xpath("//li[2]/a[@data-tracking-id='1_Canon']"))).click().build().perform();
		Thread.sleep(3000L);
		
		//----------------------Select First 3----------------
		List<WebElement> pName= driver.findElements(By.xpath("//*[@class='pu-compare pu-border-top']/input"));
		
		for(int i=0;i<=2;i++)
		{
			pName.get(i).click();
		}
		Thread.sleep(2000L);
		
		//----------------------Compare & switch the first 3-------------------
		String ParentWinId = driver.getWindowHandle();
		js.executeScript("fk_compare.goToCompare()", "");
		Thread.sleep(2000L);
		
		for(String winHandle: driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
		
		bestProductLogic();
		js.executeScript("window.scrollBy(0,2500)", "");
		driver.findElement(By.xpath("//*[@class='ans positive']/div[2]")).click();
		Thread.sleep(2000L);
		driver.switchTo().window(ParentWinId);	
	}
	
	void bestProductLogic()
	{
		List<WebElement> pName = driver.findElements(By.xpath("//*[@class='fk-prod-title']/a"));
		List<WebElement> productAvailability = driver.findElements(By.xpath("//*[@class='available']/b"));
		List<WebElement> comparePagePrice1 = driver.findElements(By.xpath("//*[@id='comp-detail-info']/tbody/tr[4]/td/span"));
		List<WebElement> productDelivery = driver.findElements(By.xpath("//*[@class='available']"));
		
		//------------Fetch and sort the compare page price------------
		ArrayList<Integer> comparePagePrice2 = new ArrayList<Integer>();
		for(int i=0; i<3; i++)
		{
			comparePagePrice2.add(Integer.parseInt(comparePagePrice1.get(i).getText().replaceAll("[^0-9]", "")));	
		}
		
		Collections.sort(comparePagePrice2);
		System.out.println("Sorted Price" + comparePagePrice2);
		
		int lowestPrice= comparePagePrice2.get(0);
		
		//-------------compare all the prices with the lowest price---------
		for(int j=0;j<3;j++)
		{			
			if(productAvailability.get(j).getText().equals("In Stock.") && lowestPrice== (Integer.parseInt(comparePagePrice1.get(j).getText().replaceAll("[^0-9]", ""))))
			{
				String prName = pName.get(j).getAttribute("title");
				System.out.println("Name of the Product with lowest price is '" + prName + "' which is of Rs. " + lowestPrice + ". This Product is ");
				System.out.print(productDelivery.get(j).getText());
			}
		}
	}
}
