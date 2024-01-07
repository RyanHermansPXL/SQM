package SQM.web.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class inventoryObject extends BasePageObject{
    public inventoryObject(WebDriver driver) {
        super(driver);
    }


    //State transition testing
    public void addProductsToCart(){
        WebElement elementAddBackpack = waitForElementPresent(By.id("add-to-cart-sauce-labs-backpack"), Duration.ofMillis(500));
        elementAddBackpack.click();

        WebElement elementAddBikeLight = waitForElementPresent(By.id("add-to-cart-sauce-labs-bike-light"), Duration.ofMillis(500));
        elementAddBikeLight.click();

        WebElement elementAddBoltTshirt = waitForElementPresent(By.id("add-to-cart-sauce-labs-bolt-t-shirt"), Duration.ofMillis(500));
        elementAddBoltTshirt.click();

        WebElement elementAddJacket = waitForElementPresent(By.id("add-to-cart-sauce-labs-fleece-jacket"), Duration.ofMillis(500));
        elementAddJacket.click();

        WebElement elementAddOnesie = waitForElementPresent(By.id("add-to-cart-sauce-labs-onesie"), Duration.ofMillis(500));
        elementAddOnesie.click();

        WebElement elementRedShirt = waitForElementPresent(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"), Duration.ofMillis(500));
        elementRedShirt.click();
    }

    public String checkStandardUserIsLoggedIn(){
        WebElement elementProduct = waitForElementPresent(By.cssSelector("span.title"), Duration.ofMillis(500));
        return elementProduct.getText();
    }


    public List<WebElement> filterByPriceHighToLow() {
        WebElement filterDropdown = waitForElementPresent(By.className("product_sort_container"), Duration.ofMillis(500));
        Select select = new Select(filterDropdown);
        select.selectByVisibleText("Price (low to high)");
        List<WebElement> products = driver.findElements(By.className("inventory_item_price"));
        return products;
    }

    public List<WebElement> filterByPriceLowToHigh() {
        WebElement filterDropdown = waitForElementPresent(By.className("product_sort_container"), Duration.ofMillis(500));
        Select select = new Select(filterDropdown);
        select.selectByVisibleText("Price (high to low)");
        List<WebElement> products = driver.findElements(By.className("inventory_item_price"));
        return products;
    }

    public List<WebElement> filterByNameAtoZ() {
        WebElement filterDropdown = waitForElementPresent(By.className("product_sort_container"), Duration.ofMillis(500));
        Select select = new Select(filterDropdown);
        select.selectByVisibleText("Name (A to Z)");
        List<WebElement> products = driver.findElements(By.className("inventory_item_price"));
        return products;
    }

    public List<WebElement> filterByNameZtoA() {
        WebElement filterDropdown = waitForElementPresent(By.className("product_sort_container"), Duration.ofMillis(500));
        Select select = new Select(filterDropdown);
        select.selectByVisibleText("Name (Z to A)");
        List<WebElement> products = driver.findElements(By.className("inventory_item_price"));
        return products;
    }

    public void clickMyCart(){
        WebElement elementCart = waitForElementPresent(By.className("shopping_cart_link"), Duration.ofMillis(500));
        elementCart.click();
    }

    //We klikken op de titel van de backpack product
    public void clickOnItemTitleBackpack(){
        WebElement backpackElement = waitForElementPresent(By.cssSelector(".inventory_item_name"), Duration.ofMillis(1000));
        backpackElement.click();
    }

    //We klikken op de image van de backpack product
    public void clickOnItemImageBackpack(){
        WebElement backpackElement = waitForElementPresent(By.xpath("//img[@alt='Sauce Labs Backpack']"), Duration.ofMillis(1000));
        backpackElement.click();
    }

    //Click on sidebar
    public void clickSidebar(){
        WebElement elementSidebar = waitForElementPresent(By.id("react-burger-menu-btn"), Duration.ofMillis(500));
        elementSidebar.click();
    }

    //Click on logout button
    public void clickLogout(){
        WebElement elementSidebar = waitForElementPresent(By.id("logout_sidebar_link"), Duration.ofMillis(500));
        elementSidebar.click();
    }

    //Click on all items
    public void clickAllItems(){
        WebElement elementAllItems = waitForElementPresent(By.id("inventory_sidebar_link"), Duration.ofMillis(500));
        elementAllItems.click();
    }





}
