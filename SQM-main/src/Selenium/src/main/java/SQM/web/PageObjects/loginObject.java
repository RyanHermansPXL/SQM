package SQM.web.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class loginObject extends BasePageObject{
    public loginObject(WebDriver driver) {
        super(driver);
    }

    public void loginAsStandardUser(String user){


        WebElement elementUsername = waitForElementPresent(By.id("user-name"), Duration.ofMillis(500));
        elementUsername.clear();
        elementUsername.sendKeys(user);

        WebElement elementPassword = waitForElementPresent(By.id("password"), Duration.ofMillis(500));
        elementPassword.clear();
        elementPassword.sendKeys("secret_sauce");

        WebElement elementLoginbutton = waitForElementPresent(By.id("login-button"), Duration.ofMillis(500));
        elementLoginbutton.click();
    }

    public String checkErrorWhenUsernameIsNotFilledIn(){
        WebElement elementLoginbutton = waitForElementPresent(By.id("login-button"), Duration.ofMillis(500));
        elementLoginbutton.click();

        WebElement errorElement = waitForElementPresent(By.cssSelector("[data-test='error']"), Duration.ofMillis(500));
        return errorElement.getText();

    }

    public String checkErrorWhenPasswordIsNotFilledIn(){
        WebElement elementUsername = waitForElementPresent(By.id("user-name"), Duration.ofMillis(500));
        elementUsername.sendKeys("standard_user");
        WebElement elementLoginbutton = waitForElementPresent(By.id("login-button"), Duration.ofMillis(500));
        elementLoginbutton.click();

        WebElement errorElement = waitForElementPresent(By.cssSelector("[data-test='error']"), Duration.ofMillis(500));
        return errorElement.getText();

    }



    public String checkIfUserIsLoggedout(){
        WebElement elementLoggedIn = waitForElementPresent(By.id("login-button"), Duration.ofMillis(500));
        return elementLoggedIn.getAttribute("value");
    }



}
