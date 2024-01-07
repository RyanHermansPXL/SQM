package SQM.web.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class inventoryItemObject extends BasePageObject {
    public inventoryItemObject(WebDriver driver) {
        super(driver);
    }

    public String checkIfOnItemPage(){
        WebElement elementBackToProducts = waitForElementPresent(By.id("back-to-products"), Duration.ofMillis(500));
        return elementBackToProducts.getText();

    }

    public void navigateToShoppingCartFromItemPage(){
        WebElement elementShoppingCart = waitForElementPresent(By.className("shopping_cart_link"), Duration.ofMillis(500));
        elementShoppingCart.click();

    }

    public void clickAddBackpackToCart(){
        WebElement elementAddToCart = waitForElementPresent(By.id("add-to-cart-sauce-labs-backpack"), Duration.ofMillis(500));
        elementAddToCart.click();
    }

    public void clickRemoveBackpackToCart(){
        WebElement elementAddToCart = waitForElementPresent(By.id("remove-sauce-labs-backpack"), Duration.ofMillis(500));
        elementAddToCart.click();
    }

    public boolean checkIfBackpackIsRemovedFromCart() {
        List<WebElement> products = driver.findElements(By.className("shopping_cart_badge"));
        return products.isEmpty();
    }






}
