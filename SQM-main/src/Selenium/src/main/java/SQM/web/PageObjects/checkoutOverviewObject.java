package SQM.web.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class checkoutOverviewObject extends BasePageObject{
    public checkoutOverviewObject(WebDriver driver) {
        super(driver);
    }

    public String checkTheTaxOfProducts(){

        WebElement elementLabelTax = waitForElementPresent(By.className("summary_subtotal_label"), Duration.ofMillis(500));
        //"Item total: $129.94" is the string and i parse it to 129.94.
        double checkTax = Double.parseDouble(elementLabelTax.getText().split("\\$")[1]) * 0.08;
        //The string needs to be format from "," to "." as decimal seperator
        return String.format(Locale.US, "%.2f", checkTax);

    }

    //These are the prices from every product in cart
    public double getTotalItemPriceCartPrice() {
        double totalPrice = 0.0;
        List<WebElement> products = driver.findElements(By.className("inventory_item_price"));
        for (WebElement product : products) {
            // Assuming the price is in a format like "$10.99" and needs to be converted to a double
            double price = Double.parseDouble(product.getText().replace("$", ""));
            // Add the price to the total
            totalPrice += price;
        }
        return totalPrice;
    }

    //This returns the label 'item total"
    public double returnForCheckTotalItemPrice(){
        WebElement elementLabelTotalItemPrice = waitForElementPresent(By.className("summary_subtotal_label"), Duration.ofMillis(500));
        double totalItemPrice = Double.parseDouble(elementLabelTotalItemPrice.getText().split("\\$")[1]);
        return totalItemPrice;
    }

    //This returns the label 'Total"
    public double returnForCheckTotalPrice(){
        WebElement elementLabelTotalItemPrice = waitForElementPresent(By.className("summary_info_label summary_total_label"), Duration.ofMillis(500));
        return Double.parseDouble(elementLabelTotalItemPrice.getText().split("\\$")[1]);

    }

    public void clickFinish(){
        WebElement elementFinish = waitForElementPresent(By.id("finish"), Duration.ofMillis(500));
        elementFinish.click();
    }

    public String checkCompletion(){
        WebElement headerElement = driver.findElement(By.className("complete-header"));
        return headerElement.getText();
    }

    public void clickBackHome(){
        WebElement elementBack = driver.findElement(By.id("back-to-products"));
        elementBack.click();
    }
}
