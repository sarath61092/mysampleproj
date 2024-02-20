package artifact;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search extends BasePage {
	WebDriver driver;
	By searchBox = By.name("q");
	By samsungCheckBox = By.xpath("//div[text()='SAMSUNG']//../div");
	By flipkartAssuredCheckbox = By.xpath("//div[@class='_3U-Vxu']//..//../div");
	By priceHighToLowOption = By.xpath("//li[text()='Price -- High to Low']");

	public Search(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// WebElement samsungCheckbox = driver.findElement(samsungCheckBox);

	public void searchProduct(String productName) {
		// driver.findElement(searchBox).sendKeys(productName);

		// click(driver.findElement(searchBox));
		clearAndSendKeys(driver.findElement(searchBox), productName);
		driver.findElement(searchBox).sendKeys(Keys.RETURN);

	}

	public void selectSamsungCheckbox() {
		click(driver.findElement(samsungCheckBox));
	}

	public void selectFlipkartAssuredCheckbox() {
		click(driver.findElement(flipkartAssuredCheckbox));
	}

	public void clickHightoLow() {
		click(driver.findElement(priceHighToLowOption));
	}

	public void printProductDetails() {
		try {
			waitForElementVisibility(driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]")));
		} catch (Exception e) {

			System.out.println("catch " + e.getMessage());
		}

		List<WebElement> productNameElements = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> productPriceElements = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		List<WebElement> productLinkElements = driver.findElements(By.xpath("//a[@class='_1fQZEK']"));
		List<String> productNames = new ArrayList<String>();
		List<String> productPrices = new ArrayList<String>();
		List<String> productLinks = new ArrayList<String>();

		System.out.println("productNames.size " + productNameElements.size() + " productPrices.size "
				+ productPriceElements.size() + " productLinks.size " + productLinkElements.size());

		for (WebElement productElement : productNameElements) {

			// Product Name
			//scrollToElement(productElement);
			String productName = productElement.getText();
			productNames.add(productName);
		}

		for (WebElement productElement : productPriceElements) {

			// Product Name
			//scrollToElement(productElement);
			String productPrice = productElement.getText();
			productPrices.add(productPrice);
		}

		for (WebElement productElement : productLinkElements) {

			// Product Name
			//scrollToElement(productElement);
			String productLink = productElement.getAttribute("href");
			productLinks.add(productLink);
		}

		for (int i = 0; i < productNames.size(); i++) {
			System.out.println("The Product Name is " + productNames.get(i) + " And the Price is "
					+ productPrices.get(i) + " And The Product Link is " + productLinks.get(i));

		}
	}

}
