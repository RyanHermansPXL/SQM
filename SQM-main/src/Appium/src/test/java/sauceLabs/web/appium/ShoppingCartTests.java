package sauceLabs.web.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sauceLabs.web.pageObjects.TestSetup;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ShoppingCartTests {


    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        TestSetup.setUp();
    }


    @Test
    public void AddAndRemoveProductFromCartTest() throws InterruptedException, MalformedURLException {

        // Swipe down on Android

        Thread.sleep(4000);
        WebElement usernameTxt = TestSetup.device.findElement(By.id("user-name"));
        Thread.sleep(4000);
        usernameTxt.click();
        Thread.sleep(4000);
        usernameTxt.sendKeys("problem_user");
        WebElement password = TestSetup.device.findElement(By.id("password"));
        password.click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        password.sendKeys("secret_sauce");
        Thread.sleep(2000);

        WebElement loginKnop = TestSetup.device.findElement(By.id("login-button"));
        Thread.sleep(2000);
        loginKnop.click();
        Thread.sleep(2000);
        System.out.println(TestSetup.device.getPageSource());
        WebElement element = TestSetup.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shopping_cart_container")));
        Thread.sleep(2000);
        element.click();
        Thread.sleep(2000);

        WebElement checkout = TestSetup.device.findElement(By.id("checkout"));
        assert(checkout.isDisplayed());


        Thread.sleep(2000);
        WebElement continueShopping = TestSetup.device.findElement(By.id("continue-shopping"));
        Thread.sleep(2000);
        assert(continueShopping.isDisplayed());


        Thread.sleep(2000);
        continueShopping.click();
        Thread.sleep(2000);

        WebElement header = TestSetup.device.findElement(By.id("header_container"));
        Thread.sleep(2000);
        assert(header.isDisplayed());


        Thread.sleep(2000);
        WebElement addToCart = TestSetup.device.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        Thread.sleep(2000);
        assert (addToCart.getText().equals("Add to cart"));
        Thread.sleep(2000);
        addToCart.click();

        Thread.sleep(2000);
        //assert(addToCart.getAttribute("content-desc").equals("Remove"));
        Thread.sleep(2000);

        Thread.sleep(2000);
        WebElement winkelmand = TestSetup.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shopping_cart_container")));
        winkelmand.click();
        Thread.sleep(2000);

        WebElement product = TestSetup.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart_contents_container")));
        Thread.sleep(2000);
        assert(product.isDisplayed());
        Thread.sleep(2000);

        WebElement remove = TestSetup.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remove-sauce-labs-backpack")));
        Thread.sleep(2000);
        assert(remove.isDisplayed());
        remove.click();
        Thread.sleep(2000);

    }

}