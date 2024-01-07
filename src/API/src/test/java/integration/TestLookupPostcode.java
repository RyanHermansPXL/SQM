package integration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import postcodesio.models.body.PostcodeBody;
import postcodesio.models.body.PostcodesBody;
import postcodesio.serviceObjects.AllServices;

public class TestLookupPostcode {
    private AllServices postcodeServices;

    @BeforeClass
    public void setup() {
        postcodeServices = new AllServices();
    }

    //Kijken als het mogelijk is om één postcode op te vragen
    @Test
    public void LookupPostcodeWithParameter() {

        PostcodeBody response = postcodeServices.lookupPostcode.getLookupPostcode("OX495NU");
        Assert.assertEquals(response.status, 200);
    }

    @Test
    public void LookupPostcodeWithoutParameter() {

        PostcodeBody response = postcodeServices.lookupPostcode.getLookupPostcode("");
        Assert.assertEquals(response.status, 400);
    }

    @Test
    public void LookupPostcodeWithWrongParameter() {

        PostcodeBody response = postcodeServices.lookupPostcode.getLookupPostcode("1");
        Assert.assertEquals(response.status, 404);
    }
}
