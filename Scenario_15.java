import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class Scenario_15 {
	public static void main(String args[]) throws Exception{
		WebDriver driver =  new FirefoxDriver();
		
		//------------------Scene 2----------------------------
		driver.get("http://www.snapdeal.com/");
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//*[@id='keyword']")).sendKeys("iPhone");
		driver.findElement(By.xpath("//*[@id='keyword']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000L);
		
		//------------------Scene 2----------------------------
		JavascriptExecutor js = (JavascriptExecutor)driver;   
		js.executeScript("window.scrollBy(0,3000)", "");
		Thread.sleep(3000L);
		
		WebElement Slider1 = driver.findElement(By.xpath("//*[@id='slider-Price-id']/a[1]"));
		WebElement Slider2 = driver.findElement(By.xpath("//*[@id='slider-Price-id']/a[2]"));
		
		Actions moveSlider = new Actions(driver);
		moveSlider.dragAndDropBy(Slider1, 44, 0).build().perform();
	    Thread.sleep(3000L);	    
	    moveSlider.dragAndDropBy(Slider2, -148, 0).build().perform();
		
	    //------------------Scene 3----------------------------
	    driver.findElement(By.xpath("//div/label[@class='lang']")).click();
	    Thread.sleep(2000L);
		String Sprice = driver.findElement(By.xpath("//*[@id='price']")).getText();
		
		Sprice = Sprice.replaceAll("[^0-9]",""); //Remove Rs.
		int price= Integer.parseInt(Sprice);

			if( (price>15000) && (price<20000) ){
				System.out.println("Rs." + price + " Price is under selected criteria");	
			} else{
				System.out.println( "Rs." + price + " Price is not under selected criteria");
			}
		driver.close();
	}	
}