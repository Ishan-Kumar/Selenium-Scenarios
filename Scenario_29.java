import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Scenario_29 
{
	public static void main(String args[]) throws Exception
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");
		
		//Search the word
		String sTerm = "Selenium";
		driver.findElement(By.xpath("//*[@class='sbib_b']/div/input")).sendKeys(sTerm);
		driver.findElement(By.xpath("//*[@class='sbib_b']/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000l);
	
		
		for(int i =1; i<3; i++)
		{
			
			String selectNewTab = Keys.chord(Keys.COMMAND,Keys.RETURN);
			driver.findElements(By.xpath("//h3[@class='r']/a")).get(i).sendKeys(selectNewTab);
			driver.findElements(By.xpath("//h3[@class='r']/a")).get(i).sendKeys(Keys.chord(Keys.CONTROL,Keys.TAB));
			Thread.sleep(1000l);
			System.out.println("Title of the link " + i + " " + driver.getTitle());
			Thread.sleep(2000l);
			driver.findElement(By.tagName("body")).sendKeys(Keys.chord(Keys.COMMAND, "w"));
			
		}
		
		System.out.println("Title of the parent window is: " + driver.getTitle());
		Thread.sleep(2000l);
		driver.quit();
		
	}
}
