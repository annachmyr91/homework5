package myprojects.automation.assignment5.tests;

import myprojects.automation.assignment5.BaseTest;
import myprojects.automation.assignment5.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlaceOrderTest extends BaseTest {


    @Test
    public void checkSiteVersion() {
        // TODO open main page and validate website version
        driver.get(Properties.getBaseUrl());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".products")));
        boolean isMobileVersion = driver.findElement(By.xpath("//body//i[@class=\"material-icons d-inline\"]")).isDisplayed();

        if (isMobileTesting == true) {
            Assert.assertTrue(isMobileVersion, "Mobile version is not displayed");
        } else Assert.assertFalse(isMobileVersion, "Desktop version is not displayed");
    }


    @Test(dependsOnMethods = "checkSiteVersion")
    public void createNewOrder() {
        // TODO implement order creation test
        driver.get(Properties.getBaseUrl());
        JavascriptExecutor je = driver;
        driver.findElement(By.className("all-product-link")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("products")));

        // open random product
        List<WebElement> items = new ArrayList<>();
        items = driver.findElements(By.cssSelector(".products .product-description a"));
        int itemsSize = items.size();

        Random random = new Random();
        int randomNumber = random.nextInt(itemsSize);

        WebElement randomElement = driver.findElements(By.cssSelector(".products .product-description a")).get(randomNumber);
        randomElement.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("product-prices")));
        driver.findElement(By.className("add-to-cart")).click();

        driver.switchTo().frame("frame");

        // wait.until(ExpectedConditions.(driver.findElement(By.className("modal-content"))));
        // driver.findElement(By.cssSelector(".cart-content .btn-primary")).click();


/*
        String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler); // switch to popup window

// Now you are in the popup window, perform necessary actions here

        driver.findElement(By.cssSelector(".cart-content .btn-primary")).click();

        driver.switchTo().window(parentWindowHandler);  // switch back to parent window
*/


        // save product parameters

        // add product to Cart and validate product information in the Cart

        // proceed to order creation, fill required information

        // place new order and validate order summary

        // check updated In Stock value
    }

}
