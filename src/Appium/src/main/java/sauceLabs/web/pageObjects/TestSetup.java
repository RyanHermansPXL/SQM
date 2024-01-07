package sauceLabs.web.pageObjects;

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

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
public class TestSetup {
    public static AppiumDriver device;

    public static WebDriverWait wait;

    public static void setUp() throws MalformedURLException {

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");

            desiredCapabilities.setCapability(AndroidMobileCapabilityType.BROWSER_NAME, "Chrome");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:/Users/12004028/Desktop/SQM/chromedriver.exe");
            device = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
            wait = new WebDriverWait(device, Duration.ofSeconds(20));
            device.get("https://www.saucedemo.com");

    }
}
