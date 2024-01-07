package SQM.visual_user;

import SQM.web.PageObjects.SQMPages;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VisualUserUserLoginTestCheckoutOverviewTest {
    SQMPages pages = SQMPages.Init();
    long startTime;
    long endTime;

    @BeforeClass
    public void setUp() {

        startTime = System.currentTimeMillis();
        pages.loginObject.navigateTo();
        pages.loginObject.loginAsStandardUser("visual_user");
        pages.inventoryObject.addProductsToCart();
        pages.inventoryObject.clickMyCart();
        pages.myCartObject.clickCheckout();
        pages.checkoutObject.FillDetailsInCheckout();
    }

    //Check if Tax price is right
    @Test(priority = 1)
    public void testTaxTotal(){
        Assert.assertEquals("$" + pages.checkoutOverviewObject.checkTheTaxOfProducts(), "$10.40");
    }

    //Check item total products in cart
    @Test(priority = 2)
    public void testTotalItemPrice() {

        Assert.assertEquals(pages.checkoutOverviewObject.getTotalItemPriceCartPrice(), pages.checkoutOverviewObject.returnForCheckTotalItemPrice());
    }


    //Bug
    @Test(priority = 3)
    public void testTotalPrice() {
        try {
            double total = Double.parseDouble(pages.checkoutOverviewObject.checkTheTaxOfProducts()) + pages.checkoutOverviewObject.returnForCheckTotalItemPrice();
            Assert.assertEquals(pages.checkoutOverviewObject.returnForCheckTotalPrice(), total);
        }catch (Exception e){
            throw new AssertionError("Test failed: Element not found within the specified time.");
        }
    }

    //Check if order is finished
    @Test(priority = 4)
    public void testIfOrderIsCompleted() {
        pages.checkoutOverviewObject.clickFinish();
        Assert.assertEquals(pages.checkoutOverviewObject.checkCompletion(), "Thank you for your order!");
    }

    //Check if navigated to home works on the page where order is finished
    @Test(priority = 5)
    public void testIfButtonToNavigateBackHomeWorks() {
        pages.checkoutOverviewObject.clickBackHome();
        Assert.assertEquals(pages.inventoryObject.checkStandardUserIsLoggedIn(), "Products");
    }

    @AfterSuite
    public void tearDown()  {
        endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Totale uitvoeringstijd van de klasse CheckoutOverviewTest: " + executionTime + " milliseconden");
        pages.quit();
    }
}
