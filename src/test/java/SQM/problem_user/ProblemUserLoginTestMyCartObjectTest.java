package SQM.problem_user;

import SQM.web.PageObjects.SQMPages;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProblemUserLoginTestMyCartObjectTest {
    SQMPages pages = SQMPages.Init();
    long startTime;
    long endTime;

    @BeforeClass
    public void setUp() {

        startTime = System.currentTimeMillis();
        pages.loginObject.navigateTo();
        pages.loginObject.loginAsStandardUser("problem_user");
    }

    //State transiton testing
    //Check if products are added to the cart
    @Test
    public void testProductsInCart(){
        pages.inventoryObject.addProductsToCart();
        Assert.assertEquals(pages.myCartObject.checkIfProductsInCart(), "6");
    }


    @AfterSuite
    public void tearDown()  {
        endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Totale uitvoeringstijd van de klasse MyCartObjectTest: " + executionTime + " milliseconden");
        pages.quit();
    }
}
