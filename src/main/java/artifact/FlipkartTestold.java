package artifact;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class FlipkartTestold extends BasePage {
	
	
	 WebDriver driver;
	public FlipkartTestold(WebDriver driver) {
		
		super(driver);
		// TODO Auto-generated constructor stub
	}


	

	 String url= "https://www.flipkart.com/";
	 By  searchBox= By.name("q");
	 

	public  void main(String[] args) {

		// Set the path to the ChromeDriver executable

		// System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

		 driver = new ChromeDriver();

		driver.manage().window().maximize();

		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Initialize ChromeDriver

		// Navigate to Flipkart home page

		driver.get(url);

		// Search for the product "Samsung Galaxy S10"

		WebElement searchBox = driver.findElement(By.name("q"));

		searchBox.sendKeys("Samsung Galaxy S10");

		searchBox.sendKeys(Keys.RETURN);

		// Apply filters

		WebElement samsungCheckbox = driver
				.findElement(By.xpath("//div[text()='SAMSUNG']//../div"));

		samsungCheckbox.click();

		WebElement flipkartAssuredCheckbox = driver
				.findElement(By.xpath("//div[@title='Flipkart Assured']/preceding-sibling::div/input"));

		flipkartAssuredCheckbox.click();

		// Sort by Price -> High to Low

		/*
		 * WebElement sortDropdown = driver.findElement(By.className("a-om9ouV"));
		 * 
		 * sortDropdown.click();
		 */

		WebElement priceHighToLowOption = driver.findElement(By.xpath("//li[text()='Price -- High to Low']"));

		priceHighToLowOption.click();

		// Wait for the search results to load

		// WebDriverWait wait = new WebDriverWait(driver, 10);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_1AtVbE']")));

		// Read the set of results that show up on page 1

		List<WebElement> productNameElements = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> productPriceElements = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		List<WebElement> productLinkElements = driver.findElements(By.xpath("//a[@class='_1fQZEK']"));
		List<ProductResultDetails> productResultDetailsList = new ArrayList<ProductResultDetails>();
		List<String> productNames = new ArrayList<String>();
		List<String> productPrices = new ArrayList<String>();
		List<String> productLinks = new ArrayList<String>();
		
		System.out.println("productNames.size " + productNames.size() + " productPrices.size " + productPrices.size() + " productLinks.size " + productLinks.size() );
	
		
		for (WebElement productElement : productNameElements) {

			// Product Name

			String productName = productElement.getText();
			productNames.add(productName);
		}
		
		for (WebElement productElement : productPriceElements) {

			// Product Name

			String productPrice = productElement.getText();
			productPrices.add(productPrice);
		}
		
		for (WebElement productElement : productLinkElements) {

			// Product Name

			String productLink = productElement.getAttribute("href");
			productLinks.add(productLink);
		}
		
		for(int i=0;i<productNames.size();i++) {
			System.out.println("The Product Name is " + productNames.get(i) + " And the Price is " + productPrices.get(i) + " And The Product Link is " + productLinks.get(i) );
			
			
			
		}
			// Display Price

			//String displayPrice = productElement.findElement(By.className("_30jeq3")).getText();

			// Link to Product Details Page

			//String productDetailsLink = productElement.findElement(By.className("IRpwTa")).getAttribute("href");

			// Print the details

			/*System.out.println("Product Name: " + productName);

			System.out.println("Display Price: " + displayPrice);

			System.out.println("Link to Product Details Page: " + productDetailsLink);

			System.out.println();*/

		

		// Close the browser

		driver.quit();

	}
	


}