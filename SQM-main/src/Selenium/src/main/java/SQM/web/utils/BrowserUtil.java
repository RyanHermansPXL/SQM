package SQM.web.utils;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {
    public static WebDriver createBrowser(String browser) {
        WebDriver webDriver;
        switch (browser) {
            case "chrome":
                WebDriver driverChrome;
                ChromeOptions handlingSSL = new ChromeOptions();
                if (System.getenv("HEADLESS") != null) {
                    handlingSSL.addArguments("--headless");
                }
                handlingSSL.setAcceptInsecureCerts(true);
                ChromeDriverManager.chromedriver().setup();
                driverChrome = new ChromeDriver(handlingSSL);
                webDriver = driverChrome;
                break;
            case "firefox":
                WebDriver driver;
                FirefoxDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                webDriver = driver;
                break;
            default:
                throw new RuntimeException("Unsupported driver");
        }
        webDriver.manage().window().maximize();
        return webDriver;

    }

    public static WebDriver createBrowser() {
        return createBrowser(WebConfig.getDefaultBrowser());
    }
}
