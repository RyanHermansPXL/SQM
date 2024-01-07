package SQM.web.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class checkoutInformationObject extends BasePageObject{

    public checkoutInformationObject(WebDriver driver) {
        super(driver);
    }

    public void clickFromCheckout(){
        WebElement elementContinue = waitForElementPresent(By.id("continue"), Duration.ofMillis(500));
        elementContinue.click();
    }

    //Fills all details
    public void FillDetailsInCheckout(){
        WebElement elementFirstName = waitForElementPresent(By.id("first-name"), Duration.ofMillis(500));
        elementFirstName.sendKeys("Ryan");

        WebElement elementLastName = waitForElementPresent(By.id("last-name"), Duration.ofMillis(500));
        elementLastName.sendKeys("Hermans");

        WebElement elementPostalCode = waitForElementPresent(By.id("postal-code"), Duration.ofMillis(500));
        elementPostalCode.sendKeys("3600");

        clickFromCheckout();


    }

    public void FillDetailsFirstName(){
        WebElement elementFirstName = waitForElementPresent(By.id("first-name"), Duration.ofMillis(500));
        elementFirstName.sendKeys("Ryan");


    }

    public void FillDetailsLastName(){
        WebElement elementFirstName = waitForElementPresent(By.id("last-name"), Duration.ofMillis(500));
        elementFirstName.sendKeys("Hermans");


    }

    public String checkErrorWhenNameIsNotFilledIn(){

        clickFromCheckout();
        WebElement errorElement = waitForElementPresent(By.cssSelector("[data-test='error']"), Duration.ofMillis(500));
        return errorElement.getText();

    }

    public String checkWhenEverythingIsFilledIn(){

        WebElement spanElement = waitForElementPresent(By.cssSelector("span.title"), Duration.ofMillis(500));
        return spanElement.getText();
    }




}
