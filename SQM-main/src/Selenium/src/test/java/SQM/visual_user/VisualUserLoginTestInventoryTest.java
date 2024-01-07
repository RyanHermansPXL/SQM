package SQM.visual_user;

import SQM.web.PageObjects.SQMPages;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VisualUserLoginTestInventoryTest {

    SQMPages pages = SQMPages.Init();
    long startTime;
    long endTime;

    @BeforeClass
    public void setUp() {

        startTime = System.currentTimeMillis();
        pages.loginObject.navigateTo();
        pages.loginObject.loginAsStandardUser("visual_user");
    }

    //Check if products are categorized from high to low
    @Test(priority = 1)
    public void testFilterByPriceHighToLow() {

        Assert.assertEquals(pages.inventoryObject.filterByPriceHighToLow().get(0).getText(), "$7.99");
    }

    //Check if products are categorized from low to high
    @Test(priority = 2)
    public void testFilterByPriceLowToHigh() {

        Assert.assertEquals(pages.inventoryObject.filterByPriceLowToHigh().get(0).getText(), "$49.99");
    }

    //Check if products are categorized from A to Z
    @Test(priority = 3)
    public void testFilterByNameAtoZ() {

        Assert.assertEquals(pages.inventoryObject.filterByNameAtoZ().get(0).getText(), "$29.99");
    }

    //Check if products are categorized from Z to A
    @Test(priority = 4)
    public void testFilterByNameZtoA() {

        Assert.assertEquals(pages.inventoryObject.filterByNameZtoA().get(0).getText(), "$15.99");
    }

    //Check if "all items" button works
    @Test(priority = 5)
    public void testAllItemsButton() throws InterruptedException {
        pages.inventoryObject.clickOnItemImageBackpack();
        pages.inventoryObject.clickSidebar();
        Thread.sleep(500);
        pages.inventoryObject.clickAllItems();
        Assert.assertEquals(pages.inventoryObject.checkStandardUserIsLoggedIn(), "Products");
    }

    @AfterSuite
    public void tearDown()  {
        endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Totale uitvoeringstijd van de klasse InventoryTest: " + executionTime + " milliseconden");
        pages.quit();
    }
}
