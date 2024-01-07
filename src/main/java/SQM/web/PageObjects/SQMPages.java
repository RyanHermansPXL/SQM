package SQM.web.PageObjects;

import SQM.web.utils.BrowserUtil;
import org.openqa.selenium.WebDriver;

public class SQMPages {

    private WebDriver driver;
    public loginObject loginObject;
    public inventoryObject inventoryObject;

    public myCartObject myCartObject;

    public inventoryItemObject inventoryItemObject;

    public checkoutInformationObject checkoutObject;

    public checkoutInformationObject checkoutInformationObject;

    public checkoutOverviewObject checkoutOverviewObject;

    private SQMPages() {
        driver = BrowserUtil.createBrowser();
        loginObject = new loginObject(driver);
        inventoryObject = new inventoryObject(driver);
        myCartObject = new myCartObject(driver);
        inventoryItemObject = new inventoryItemObject(driver);
        checkoutObject = new checkoutInformationObject(driver);
        checkoutInformationObject = new checkoutInformationObject(driver);
        checkoutOverviewObject = new checkoutOverviewObject(driver);
    }

    public static SQMPages Init() {
        return new SQMPages();
    }

    public void quit(){
        driver.quit();
    }
}
