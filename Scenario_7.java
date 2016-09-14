/*
 * Scenario 7: - (Check others)
 * 1. Go to Snapdeal.com.
 * 2. Store all the categories. 
 * 3. Navigate to some different page in snapdeal and verify that the list of categories did not change. 
 **/

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class Scenario_7 
{
	//------------ Initializing global object driver----------------	
	static WebDriver driver = new FirefoxDriver();
	
	public static void main(String[] args) throws Exception
	{
		Scenario_7 obj = new Scenario_7();
		obj.snap_store();
	}
	
	void snap_store() throws Exception
	{
		//-----------Scene 2-----------------
		driver.get("http://www.snapdeal.com/");
		List<String> categoriesPage1= new ArrayList();

		for(int row=1; row<12; row++)
		{
			categoriesPage1.add(driver.findElement(By.xpath("//*[@id='leftNavNemu']/div/div[1]/ul/li[" + row + "]/a/span[1]")).getText());
		}

		System.out.println("Total no. of categories for page 1 are: " + categoriesPage1.size());

		//-----------Scene 3-----------------
		driver.findElement(By.xpath("//*[@id='226-header']/div[1]/a/h2")).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@id='navBarWrapper']/div[1]/div[1]/div[1]/label"))).build().perform();
		Thread.sleep(4000L);

		List<String> categoriesPage2 = new ArrayList<String>();
		for(int row=1; row<12; row++)
		{
			categoriesPage2.add(driver.findElement(By.xpath("//*[@id='leftNavNemu']/div/div[1]/ul/li[" + row + "]/a/span[1]")).getText());
		}
		System.out.println("Total no. of categories for page 2 are: " + categoriesPage1.size());

		//Compare both the arrays
		if(categoriesPage1.size() == categoriesPage2.size())
		{
			System.out.println("Categories are equal in both the page, here is the list: ");
			for(int row=0; row<=12; row++)
			{
				System.out.println("Page 1 category: " + categoriesPage1.get(row) + ", is equal to, category of page 2 which is also: " + categoriesPage2.get(row));
				
			}

		}else{
			System.out.println("Categories aren't equal");			
		}

		driver.quit();
	}
	
	
}
	


