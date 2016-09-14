/*
 * Scenario 24:
 * 1. Navigate to Flipkart.com
 * 2. Click on "24x7 Customer care" link at the top of the page
 * 3. There is a section - " Look up by issue type", click on each type listed one by one
 *   i. If 'View all queries related type' link is present click on that and find the number of 
 *      questions listed in the resulting page
 *   ii. If 'View all queries related type' link is not present count the number of questions
 *   iii. Find out which type has highest number of questions, and print it along with the number of 
 * 		questions for other types.
 * */


import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Scenario_24 {
	
	
	
	public static WebDriver driver= new FirefoxDriver();
	public static HashMap<String, Integer> qList = new HashMap<String, Integer>();

	public static void main(String args[]) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(1000L, TimeUnit.SECONDS);
		Scenario_24 obj1 = new Scenario_24();
		obj1.customerCare();
		driver.quit();
	}

	void customerCare() throws Exception
	{
		driver.get("http://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("24x7 Customer Care")).click();
		
		List<WebElement> categoryType = driver.findElements(By.xpath("//div[@id='browse-category']//li/a")); 
				
		for(int i=0; i<categoryType.size(); i++)
		{
			if(categoryType.get(i).getText().equals("Others"))
			{
				System.out.println(categoryType.get(i).getText());
				categoryType.get(i).click();
				driver.findElement(By.linkText("View All")).click();

				List<WebElement> OthersQName = driver.findElements(By.xpath("//*[@class='fk-font-14 bmargin10']"));
					
					for(int ViewAllLinks=1; ViewAllLinks<=OthersQName.size();)
					{
						String QuestionName=driver.findElement(By.xpath("//*[@id='fk-mainbody-id']/div/div/div[1]/div/div["+ViewAllLinks+"]")).getText();
						ViewAllLinks=ViewAllLinks+1;
					    
						int questionNum= driver.findElements(By.xpath("//*[@id='fk-mainbody-id']/div/div/div[1]/div/div["+ViewAllLinks+"]/ul/li")).size();
						qList.put(QuestionName, questionNum);
					    
						//ViewAllLinks=ViewAllLinks+1;
					 }
										
					driver.navigate().back();
					Thread.sleep(1000L);

			} 
			else
			{
				System.out.println(categoryType.get(i).getText());
				categoryType.get(i).click();

				driver.findElement(By.className("links")).click();
				int questionNum = driver.findElements(By.xpath("//li[@class='QA']")).size();
				System.out.println(" Questions are" + questionNum);
				driver.navigate().back();
				Thread.sleep(1000L);


				//Reinitialize the value in the end as it expires after the loop ends
				categoryType = driver.findElements(By.xpath("//div[@id='browse-category']//li/a")); 

				//to avoid boundary exception
				if(categoryType.size()==i)
				{
					break;
				}
				else
					qList.put(categoryType.get(i).getText(), questionNum);
			}
		}
		
		System.out.println(qList);
		
	}
	
}
