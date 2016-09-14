/*
 * Scenario 21:
 * 1. Search with any term on Flipkart
 * 2. Print the product name with highest number of ratings and the star rating for that product
 * 3. If multiple products having the highest rating print all those products along with star points
 * */


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Scenario_21 {

	public static void main(String args[]) throws Exception{
	WebDriver driver = new FirefoxDriver();
	
	//-----------------Scene 1--------------------------
	driver.get("http://www.flipkart.com/");
	String sTerm= "rc helicopter";
	driver.findElement(By.xpath("//*[@id='fk-top-search-box']")).sendKeys(sTerm);
	driver.findElement(By.xpath("//*[@id='fk-top-search-box']")).sendKeys(Keys.ENTER);
	Thread.sleep(2000L);
	
	//-----------------Scene 2--------------------------
	driver.findElement(By.xpath("//*[@id='sort-dropdown']/span[2]")).click();
	Thread.sleep(1000L);
	
	System.out.println("Search Term is: " + sTerm);
	int pNum = driver.findElements(By.xpath("//*[@class='pu-rating']")).size();
	System.out.println("No. of Highest rating products for " +sTerm+ " is: " + pNum);
	System.out.println();
	System.out.println("Here is the List: ");
	System.out.println();
	
	//-----------------Scene 3--------------------------
	List<WebElement> pName = driver.findElements(By.xpath("//*[@class='pu-rating']//parent::div/div/a")); // for product name
	List<WebElement> pStar = driver.findElements(By.xpath("//*[@class='fk-stars-small']")); // for stars	
	List<WebElement> pRatings = driver.findElements(By.xpath("//*[@class='pu-rating']"));
	
		//-----------
		HashMap<String, String> table1 =new HashMap<String, String>();
		ArrayList<String> arTemp = new ArrayList<String>();
		ArrayList<Integer> arFinal = new ArrayList<Integer>();
		
		for(int i=0; i< pNum; i ++)
		{	
			
			String j=pRatings.get(i).getText().replaceAll("[^0-9]", "");
			table1.put(j, pName.get(i).getText());
			arTemp.add(j);				 
			arFinal.add( Integer.parseInt(arTemp.get(i)));	
			
		}
		
		System.out.println("Unsorted array" + arTemp);
		Collections.sort(arFinal);
		System.out.println("Sorted array"+ arFinal);	
		System.out.println(table1);

	}	
	
	
}