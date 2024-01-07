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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sauceLabs.web.pageObjects.TestSetup;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginFailsTests {



    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        TestSetup.setUp();
    }
    @Test
    public void testPasswordFilledIn() throws InterruptedException, MalformedURLException {
        LoginFailsTests.setUp();
        Thread.sleep(2000);
        WebElement usernameTxt = TestSetup.device.findElement(By.id("user-name"));
        Thread.sleep(2000);
        usernameTxt.click();
        Thread.sleep(2000);
        usernameTxt.clear();
        Thread.sleep(2000);
        WebElement password = TestSetup.device.findElement(By.id("password"));
        password.click();
        Thread.sleep(2000);
        usernameTxt.clear();
        Thread.sleep(2000);
        password.sendKeys("secret_sauce");
        Thread.sleep(2000);
        WebElement loginKnop = TestSetup.device.findElement(By.id("login-button"));
        Thread.sleep(2000);
        usernameTxt.click();
        usernameTxt.clear();
        Thread.sleep(2000);
        loginKnop.click();
        WebElement errorMsg = TestSetup.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_button_container")));
        Thread.sleep(2000);
        assert(errorMsg.getText().equals("Epic sadface: Username is required"));
        Thread.sleep(3000);

    }

    @Test
    public void testFieldsNotFilledIn() throws InterruptedException, MalformedURLException {
        LoginFailsTests.setUp();
        Thread.sleep(2000);
        System.out.println(TestSetup.device.getPageSource());
        WebDriverWait wait = new WebDriverWait(TestSetup.device, Duration.ofSeconds(20));
        WebElement loginKnop = TestSetup.device.findElement(By.id("login-button"));
        Thread.sleep(2000);
        loginKnop.click();
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_button_container")));
        Thread.sleep(2000);
        assert(errorMsg.getText().equals("Epic sadface: Username is required"));
        Thread.sleep(3000);
    }


    @Test
    public void testStandaardUsernameFilledIn() throws InterruptedException, MalformedURLException {
       LoginFailsTests.setUp();
        Thread.sleep(2000);
        System.out.println(TestSetup.device.getPageSource());
        WebDriverWait wait = new WebDriverWait(TestSetup.device, Duration.ofSeconds(20));
        WebElement usernameTxt = TestSetup.device.findElement(By.id("user-name"));
        Thread.sleep(2000);
        usernameTxt.click();
        Thread.sleep(2000);
        usernameTxt.sendKeys("standard_user");
        Thread.sleep(2000);
        WebElement loginKnop = TestSetup.device.findElement(By.id("login-button"));
        Thread.sleep(2000);

        loginKnop.click();
        Thread.sleep(2000);
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_button_container")));
        Thread.sleep(2000);
        assert(errorMsg.getText().equals("Epic sadface: Password is required"));
        Thread.sleep(3000);

    }
    @Test
    public void testLockedOutUsernameFilledIn() throws InterruptedException, MalformedURLException {
        LoginFailsTests.setUp();
        Thread.sleep(2000);
        System.out.println(TestSetup.device.getPageSource());
        WebDriverWait wait = new WebDriverWait(TestSetup.device, Duration.ofSeconds(20));
        WebElement usernameTxt = TestSetup.device.findElement(By.id("user-name"));
        Thread.sleep(2000);
        usernameTxt.click();
        Thread.sleep(2000);
        usernameTxt.sendKeys("locked_out_user");
        Thread.sleep(2000);
        WebElement password = TestSetup.device.findElement(By.id("password"));
        password.click();
        Thread.sleep(2000);
        password.sendKeys("secret_sauce");
        Thread.sleep(2000);
        WebElement loginKnop = TestSetup.device.findElement(By.id("login-button"));
        Thread.sleep(2000);
        loginKnop.click();
        Thread.sleep(2000);
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_button_container")));
        Thread.sleep(2000);
        assert(errorMsg.getText().equals("Epic sadface: Sorry, this user has been locked out."));
        Thread.sleep(3000);
    }
    @Test
    public void testProblemUserNameFilledIn() throws InterruptedException, MalformedURLException {
        LoginFailsTests.setUp();
        Thread.sleep(2000);
        System.out.println(TestSetup.device.getPageSource());
        WebDriverWait wait = new WebDriverWait(TestSetup.device, Duration.ofSeconds(20));
        WebElement usernameTxt = TestSetup.device.findElement(By.id("user-name"));
        Thread.sleep(2000);
        usernameTxt.click();
        Thread.sleep(2000);
        usernameTxt.sendKeys("problem_user");
        Thread.sleep(2000);
        WebElement loginKnop = TestSetup.device.findElement(By.id("login-button"));
        Thread.sleep(2000);

        loginKnop.click();
        Thread.sleep(2000);
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_button_container")));
        Thread.sleep(2000);
        assert(errorMsg.getText().equals("Epic sadface: Password is required"));
        Thread.sleep(3000);
    }
    @Test
    public void testPerformaceGlitchUserNameFilledIn() throws InterruptedException, MalformedURLException {
        LoginFailsTests.setUp();
        Thread.sleep(2000);
        System.out.println(TestSetup.device.getPageSource());
        WebDriverWait wait = new WebDriverWait(TestSetup.device, Duration.ofSeconds(20));
        WebElement usernameTxt = TestSetup.device.findElement(By.id("user-name"));
        Thread.sleep(2000);
        usernameTxt.click();
        Thread.sleep(2000);
        usernameTxt.sendKeys("performance_glitch_user");
        Thread.sleep(2000);
        WebElement loginKnop = TestSetup.device.findElement(By.id("login-button"));
        Thread.sleep(2000);

        loginKnop.click();
        Thread.sleep(2000);
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_button_container")));
        Thread.sleep(2000);
        assert(errorMsg.getText().equals("Epic sadface: Password is required"));
        Thread.sleep(3000);
    }
    @Test
    public void testErrorUserNameFilledIn() throws InterruptedException, MalformedURLException {
        LoginFailsTests.setUp();
        Thread.sleep(2000);
        System.out.println(TestSetup.device.getPageSource());
        WebDriverWait wait = new WebDriverWait(TestSetup.device, Duration.ofSeconds(20));
        WebElement usernameTxt = TestSetup.device.findElement(By.id("user-name"));
        Thread.sleep(2000);
        usernameTxt.click();
        Thread.sleep(2000);
        usernameTxt.sendKeys("error_user");
        Thread.sleep(2000);
        WebElement loginKnop = TestSetup.device.findElement(By.id("login-button"));
        Thread.sleep(2000);

        loginKnop.click();
        Thread.sleep(2000);
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_button_container")));
        Thread.sleep(2000);
        assert(errorMsg.getText().equals("Epic sadface: Password is required"));
        Thread.sleep(3000);
    }

    @Test
    public void testVisualUserNameFilledIn() throws InterruptedException, MalformedURLException {
        LoginFailsTests.setUp();
        Thread.sleep(2000);
        System.out.println(TestSetup.device.getPageSource());
        WebDriverWait wait = new WebDriverWait(TestSetup.device, Duration.ofSeconds(20));
        WebElement usernameTxt = TestSetup.device.findElement(By.id("user-name"));
        Thread.sleep(2000);
        usernameTxt.click();
        Thread.sleep(2000);
        usernameTxt.sendKeys("visual_user");
        Thread.sleep(2000);
        WebElement loginKnop = TestSetup.device.findElement(By.id("login-button"));
        Thread.sleep(2000);

        loginKnop.click();
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_button_container")));
        Thread.sleep(2000);
        assert(errorMsg.getText().equals("Epic sadface: Password is required"));
        Thread.sleep(3000);

    }

    @Test
    public void TestWrongPassword() throws InterruptedException {
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
        password.sendKeys("sect_sauce");
        Thread.sleep(2000);

        WebElement loginKnop = TestSetup.device.findElement(By.id("login-button"));
        Thread.sleep(2000);
        loginKnop.click();

        Thread.sleep(2000);
        WebElement errorMsg = TestSetup.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_button_container")));
        Thread.sleep(2000);
        assert(errorMsg.getText().equals("Epic sadface: Username and password do not match any user in this service"));
        Thread.sleep(3000);

    }
    @Test
    public void TestWrongUsername() throws InterruptedException {
        Thread.sleep(4000);
        WebElement usernameTxt = TestSetup.device.findElement(By.id("user-name"));
        Thread.sleep(4000);
        usernameTxt.click();
        Thread.sleep(4000);
        usernameTxt.sendKeys("stand_user");
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
        WebElement errorMsg = TestSetup.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_button_container")));
        Thread.sleep(2000);
        assert(errorMsg.getText().equals("Epic sadface: Username and password do not match any user in this service"));
        Thread.sleep(3000);

    }
}
