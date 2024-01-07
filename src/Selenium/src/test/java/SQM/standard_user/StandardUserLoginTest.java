package SQM.standard_user;

import SQM.web.PageObjects.SQMPages;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Test(groups = "group1")
public class StandardUserLoginTest {
    SQMPages pages = SQMPages.Init();
    long startTime;
    long endTime;


    @BeforeClass
    public void setUp() {

        startTime = System.currentTimeMillis();
        pages.loginObject.navigateTo();
    }

    @DataProvider(name = "loginData")
    public Object[][] getData(){
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
        };
    }

    
    //Check if StandardUser is logged in
    @Test(priority = 3)
    public void testStandardUserCanLogin(){

        pages.loginObject.loginAsStandardUser("standard_user");
        Assert.assertEquals(pages.inventoryObject.checkStandardUserIsLoggedIn(), "Products");
    }

    //Check if user is logged out
    @Test(priority = 4)
    public void testUserCanLogOut() throws InterruptedException {
        pages.inventoryObject.clickSidebar();
        Thread.sleep(500);
        pages.inventoryObject.clickLogout();
        Assert.assertEquals(pages.loginObject.checkIfUserIsLoggedout(), "Login");
    }

    //Check if user gets an error when username is not filled in
    @Test(priority = 1)
    public void testIfUserGetsErrorWhenUsernameNotFilledIn(){

        Assert.assertEquals(pages.loginObject.checkErrorWhenUsernameIsNotFilledIn(), "Epic sadface: Username is required");
    }

    //Check if user gets an error when password is not filled in
    @Test(priority = 2)
    public void testIfUserGetsErrorWhenPasswordNotFilledIn(){

        Assert.assertEquals(pages.loginObject.checkErrorWhenPasswordIsNotFilledIn(), "Epic sadface: Password is required");
    }

    @AfterSuite
    public void tearDown()  {
        endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Totale uitvoeringstijd van de klasse LoginTest: " + executionTime + " milliseconden");
        pages.quit();
    }
}
