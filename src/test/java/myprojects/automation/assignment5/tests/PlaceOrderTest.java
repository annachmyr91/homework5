package myprojects.automation.assignment5.tests;

import myprojects.automation.assignment5.BaseTest;
import myprojects.automation.assignment5.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

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


    @Test
    public void createNewOrder() {
        // TODO implement order creation test

        // open random product

        // save product parameters

        // add product to Cart and validate product information in the Cart

        // proceed to order creation, fill required information

        // place new order and validate order summary

        // check updated In Stock value
    }

}
