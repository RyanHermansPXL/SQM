package SQM.web.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class myCartObject extends BasePageObject{
    public myCartObject(WebDriver driver) {
        super(driver);
    }

    public void clickCheckout(){
        WebElement elementCheckout = waitForElementPresent(By.id("checkout"), Duration.ofMillis(500));
        elementCheckout.click();
    }

    public String checkIfProductsInCart(){
        WebElement elementCart = driver.findElement(By.className("shopping_cart_badge"));
        return elementCart.getText();
    }


    public String checkIfNavigatedToShoppingCart(){
        WebElement elementLabelShoppingCart = waitForElementPresent(By.className("title"), Duration.ofMillis(500));
        return elementLabelShoppingCart.getText();
    }


}
