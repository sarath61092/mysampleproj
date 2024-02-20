package sampletypepack;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class testrun2 {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Initialize ChromeDriver
        

        // Navigate to Flipkart home page
        driver.get("https://www.flipkart.com/");

        // Search for the product "Samsung Galaxy S10"
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Samsung Galaxy S10");
        searchBox.sendKeys(Keys.RETURN);

       // Apply filters
        WebElement samsungCheckbox = driver.findElement(By.xpath("//div[text()='Samsung']/preceding-sibling::input[@type='checkbox']"));
        samsungCheckbox.click();

        WebElement flipkartAssuredCheckbox = driver.findElement(By.xpath("//div[@title='Flipkart Assured']/preceding-sibling::div/input"));
        flipkartAssuredCheckbox.click();

        // Sort by Price -> High to Low
        /*WebElement sortDropdown = driver.findElement(By.className("a-om9ouV"));
        sortDropdown.click();*/

        WebElement priceHighToLowOption = driver.findElement(By.xpath("//li[text()='Price -- High to Low']"));
        priceHighToLowOption.click();

        // Wait for the search results to load
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_1AtVbE']")));

        // Read the set of results that show up on page 1
        List<WebElement> productElements = driver.findElements(By.xpath("//div[@class='_1AtVbE']"));
        for (WebElement productElement : productElements) {
            // Product Name
            String productName = productElement.findElement(By.className("IRpwTa")).getText();

            // Display Price
            String displayPrice = productElement.findElement(By.className("_30jeq3")).getText();

            // Link to Product Details Page
            String productDetailsLink = productElement.findElement(By.className("IRpwTa")).getAttribute("href");

            // Print the details
            System.out.println("Product Name: " + productName);
            System.out.println("Display Price: " + displayPrice);
            System.out.println("Link to Product Details Page: " + productDetailsLink);
            System.out.println();
        }

        // Close the browser
        driver.quit();
    }
}