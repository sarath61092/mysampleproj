package sampletypepack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.*;

public class prototype {

	public static void main (String args []) throws InterruptedException
	
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com"); //initialize chrome driver and launch flipkart
		//driver.findElement(By.xpath("//button[@class='_2KpZ6l _2d0B4z']")).click();
		
		driver.findElement(By.name("q")).sendKeys("samsung galaxy s10"); 
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER); //search for galaxy s10
		//Thread.sleep(5000);
		
		//WebElement samsung=driver.findElement(By.xpath("//input[@class='30VH1S']"));
		//samsung.click();
		
		//WebElement samsung=driver.findElement(By.className("SAMSUNG")) ;
		//samsung.click();
		
		//WebElement fassured=driver.findElement(By.className("_24_Dny _3tCU7L"));
		//fassured.click();
		
		//driver.findElement(By.xpath("//span [@class='_10UF8M' 'Price -- High to Low']")).click();
		
		/* Select from Search Suggestions:
		 * List<WebElement> search_suggestion= driver.findElements(By.xpath("//li [@class ='Y5N33s']"));
				for(int i=0;i<search_suggestion.size()-1;i++)
		{
			System.out.println(search_suggestion.get(i).getText());
		}
				for(int i=0;i<search_suggestion.size()-1;i++)
		{
			if(search_suggestion.get(i).getText().contains("Mobiles"))
			search_suggestion.get(i).click(); */
			
		/* to show results of the page
		List <WebElement> allresults=driver.findElements(By.xpath("//li [@class='_13oc-S']"));
		for(int i=0;i<allresults.size()-1;i++)
		{
			System.out.println(allresults.get(i).getText());
			
		} */
		
		/*list with product name, display price and link to product details page */
			
	}
	
	
}
