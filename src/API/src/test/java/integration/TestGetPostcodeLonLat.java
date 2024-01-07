package integration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import postcodesio.models.body.PostcodesBody;
import postcodesio.serviceObjects.AllServices;

public class TestGetPostcodeLonLat {
    private AllServices postcodeServices;

    @BeforeClass
    public void setup() {
        postcodeServices = new AllServices();
    }

    @Test
    public void LookupPostcodeWithParameter() {

        PostcodesBody response = postcodeServices.postcodeLonLat.getPostcodeLongLat("-1.069752","51.655929");
        Assert.assertEquals(response.status, 200);
    }

    @Test
    public void LookupPostcodeWithoutParameter() {

        PostcodesBody response = postcodeServices.postcodeLonLat.getPostcodeLongLat("","");
        Assert.assertEquals(response.status, 400);
    }
}
