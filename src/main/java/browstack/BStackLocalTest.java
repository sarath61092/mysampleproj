package browstack;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import artifact.Search;

public class BStackLocalTest extends SeleniumTest {
	WebDriver driver;
	String productName = "Samsung Galaxy S10";
    @Test
    public void test() throws Exception {
    	System.out.println("BStackLocalTest");
    	driver.get("https://www.flipkart.com");
        Search search = new Search(driver);
		search.searchProduct(productName);
		search.selectSamsungCheckbox();
		search.selectFlipkartAssuredCheckbox();
		//search.clickHightoLow();
		search.printProductDetails();

        //Assert.assertTrue(driver.getTitle().contains("BrowserStack Local"));
    }
}
