package integration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import postcodesio.models.body.PostcodeBody;
import postcodesio.serviceObjects.AllServices;

public class TestGetRandomPostcode {
    private AllServices postcodeServices;

    @BeforeClass
    public void setup() {
        postcodeServices = new AllServices();
    }

    //Kijken als endpoint een 200 status teruggeeft
    @Test
    public void GetRandomPostcode() {
        PostcodeBody response = postcodeServices.randomPostcode.getRandomPostcode();
        Assert.assertEquals(response.status, 200);
    }
}
