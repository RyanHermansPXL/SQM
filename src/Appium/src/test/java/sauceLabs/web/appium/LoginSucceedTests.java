package sauceLabs.web.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import sauceLabs.web.pageObjects.TestSetup;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginSucceedTests {


    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        TestSetup.setUp();
    }
    @Test
    public void TestStandaardUserLogin() throws InterruptedException, MalformedURLException {
        LoginSucceedTests.setUp();
        Thread.sleep(4000);
        WebElement usernameTxt = TestSetup.device.findElement(By.id("user-name"));
        Thread.sleep(4000);
        usernameTxt.click();
        Thread.sleep(4000);
        usernameTxt.sendKeys("standard_user");
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

        WebElement header = TestSetup.device.findElement(By.id("header_container"));

        //android.view.View[@resource-id="header_container"]/android.view.View[1]
        assert(header.isDisplayed());
    }

    @Test
    public void TestProblemdUserLogin() throws InterruptedException, MalformedURLException {
        LoginSucceedTests.setUp();

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

        WebElement header = TestSetup.device.findElement(By.id("header_container"));
        Thread.sleep(2000);
        assert(header.isDisplayed());
    }

    @Test
    public void TestPerformanceGlitchUserLogin() throws InterruptedException, MalformedURLException {
        LoginSucceedTests.setUp();

        Thread.sleep(4000);
        WebElement usernameTxt = TestSetup.device.findElement(By.id("user-name"));
        Thread.sleep(4000);
        usernameTxt.click();
        Thread.sleep(4000);
        usernameTxt.sendKeys("performance_glitch_user");
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

        WebElement header = TestSetup.device.findElement(By.id("header_container"));
        Thread.sleep(2000);
        assert(header.isDisplayed());
    }


    @Test
    public void TestErrorUserLogin() throws InterruptedException, MalformedURLException {
        LoginSucceedTests.setUp();

        Thread.sleep(4000);
        WebElement usernameTxt = TestSetup.device.findElement(By.id("user-name"));
        Thread.sleep(4000);
        usernameTxt.click();
        Thread.sleep(4000);
        usernameTxt.sendKeys("error_user");
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
        WebElement header = TestSetup.device.findElement(By.id("header_container"));
        Thread.sleep(2000);
        assert(header.isDisplayed());
    }

    @Test
    public void TestVisualUserLogin() throws InterruptedException, MalformedURLException {
        LoginSucceedTests.setUp();

        Thread.sleep(4000);
        WebElement usernameTxt = TestSetup.device.findElement(By.id("user-name"));
        Thread.sleep(4000);
        usernameTxt.click();
        Thread.sleep(4000);
        usernameTxt.sendKeys("visual_user");
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

        WebElement header = TestSetup.device.findElement(By.id("header_container"));
        Thread.sleep(2000);
        assert(header.isDisplayed());
    }

}
