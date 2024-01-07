package SQM.standard_user;

import SQM.web.PageObjects.SQMPages;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(dependsOnGroups = "group1")
public class StandardUserLoginTestCheckoutInformationTest {
    SQMPages pages = SQMPages.Init();
    long startTime;
    long endTime;

    @BeforeClass
    public void setUp() {

        startTime = System.currentTimeMillis();
        pages.loginObject.navigateTo();
        pages.loginObject.loginAsStandardUser("standard_user");
        pages.inventoryObject.addProductsToCart();
        pages.inventoryObject.clickMyCart();
        pages.myCartObject.clickCheckout();
    }


    //Test to give an error when firstname is not filled in
    @Test(priority = 1)
    public void testWhenInformationFirstNameNotFilledIn(){

        Assert.assertEquals(pages.checkoutInformationObject.checkErrorWhenNameIsNotFilledIn(), "Error: First Name is required");

    }

    //Test to give an error when lastname is not filled in
    @Test(priority = 2)
    public void testWhenInformationLastNameNotFilledIn(){

        pages.checkoutInformationObject.FillDetailsFirstName();
        Assert.assertEquals(pages.checkoutInformationObject.checkErrorWhenNameIsNotFilledIn(), "Error: Last Name is required");

    }

    //Test to give an error when postalcode is not filled in
    @Test(priority = 3)
    public void testWhenInformationPostalCodeNotFilledIn(){
        pages.checkoutInformationObject.FillDetailsLastName();
        pages.checkoutInformationObject.FillDetailsFirstName();
        Assert.assertEquals(pages.checkoutInformationObject.checkErrorWhenNameIsNotFilledIn(), "Error: Postal Code is required");

    }


    //Test to give an error when everyhting is filled in
    @Test(priority = 4)
    public void testWhenEverythingIsFilledIn(){
        pages.checkoutInformationObject.FillDetailsInCheckout();
        Assert.assertEquals(pages.checkoutInformationObject.checkWhenEverythingIsFilledIn(), "Checkout: Overview");

    }

    @AfterSuite
    public void tearDown()  {
        endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Totale uitvoeringstijd van de klasse CheckoutInformationTest: " + executionTime + " milliseconden");
        pages.quit();
    }
}
