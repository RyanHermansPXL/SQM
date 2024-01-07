package SQM.web.PageObjects;

import SQM.web.utils.WebConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageObject {
    protected WebDriver driver;
    protected String url;
    protected WebDriverWait wait;

       public BasePageObject(WebDriver driver) {

        this.driver = driver;
        url = WebConfig.getBaseUrl();
        wait = new WebDriverWait(driver, WebConfig.getDefaultWait());

    }

    public WebElement waitForElementPresent(By locator, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void driverquit(){
           driver.quit();
    }
    public void navigateTo() {
        driver.get(url);
    }


}
