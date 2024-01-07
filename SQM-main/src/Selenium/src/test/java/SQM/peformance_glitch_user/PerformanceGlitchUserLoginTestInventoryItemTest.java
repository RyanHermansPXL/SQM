package SQM.peformance_glitch_user;

import SQM.web.PageObjects.SQMPages;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PerformanceGlitchUserLoginTestInventoryItemTest {
    SQMPages pages = SQMPages.Init();
    long startTime;
    long endTime;

    @BeforeClass
    public void setUp() {

        startTime = System.currentTimeMillis();
        pages.loginObject.navigateTo();
        pages.loginObject.loginAsStandardUser("performance_glitch_user");
    }

    //state transition testing
    //Test if we can navigate to the item page of the product when clicking on title
    //This is a bug
    @Test(priority = 1)
    public void testIfNavigatedToItemPageWhenClickingOnTitle(){
        try{
            pages.inventoryObject.clickOnItemTitleBackpack();
            Assert.assertEquals(pages.inventoryItemObject.checkIfOnItemPage(), "Back to products");
        }catch (Exception e){
            throw new AssertionError("Test failed: Element not found within the specified time.");
        }

    }

    //state transition testing
    //Test if we can navigate to the item page of the product when clicking on image
    @Test(priority = 2)
    public void testIfNavigatedToItemPageWhenClickingOnImage(){
        pages.inventoryObject.clickOnItemImageBackpack();
        Assert.assertEquals(pages.inventoryItemObject.checkIfOnItemPage(), "Back to products");
    }

    //state transition testing
    //Test if we can navigate to the shopping cart from the product page
    @Test(priority = 5)
    public void testIfNavigatedToShoppingCart(){

        pages.inventoryItemObject.navigateToShoppingCartFromItemPage();
        Assert.assertEquals(pages.myCartObject.checkIfNavigatedToShoppingCart(), "Your Cart");
    }

    //state transition testing
    //Test if we can add product to cart in the product page
    @Test(priority = 3)
    public void testAddToCartInProduct(){

        pages.inventoryItemObject.clickAddBackpackToCart();
        Assert.assertEquals(pages.myCartObject.checkIfProductsInCart(), "1");
    }

    //state transition testing
    //Test if we only added a backpack and remove it, that there is no number on cart image
    @Test(priority = 4)
    public void testRemoveProductInCart(){

        pages.inventoryItemObject.clickRemoveBackpackToCart();
        pages.inventoryItemObject.clickAddBackpackToCart();
        pages.inventoryItemObject.clickRemoveBackpackToCart();
        Assert.assertTrue(pages.inventoryItemObject.checkIfBackpackIsRemovedFromCart());
    }

    @AfterSuite
    public void tearDown()  {
        endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Totale uitvoeringstijd van de klasse InventoryItemTest: " + executionTime + " milliseconden");
        pages.quit();
    }

}
