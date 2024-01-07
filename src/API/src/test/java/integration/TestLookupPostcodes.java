package integration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import postcodesio.models.body.PostcodesBody;
import postcodesio.serviceObjects.AllServices;

import java.util.ArrayList;

public class TestLookupPostcodes {
    private AllServices postcodeServices;

    @BeforeClass
    public void setup() {
        postcodeServices = new AllServices();
    }

    //Kijken als het mogelijk is om een array van postcodes op te vragen
    @Test
    public void LookupPostcodes() {
        ArrayList<String> postcodes = new ArrayList<>();
        postcodes.add("OX49 5NU");
        postcodes.add("M32 0JG");
        postcodes.add("NE30 1DP");
        PostcodesBody response = postcodeServices.lookupPostcodes.lookupPostcodes(postcodes);
        Assert.assertEquals(response.status, 200);
    }

    //Kijken wanneer er geen waardes worden meegegeven de api een 400 error geeft
    @Test
    public void LookupPostcodesWithoutParameter() {
        PostcodesBody response = postcodeServices.lookupPostcodes.lookupPostcodesFail();
        Assert.assertEquals(response.status, 400);
    }

}
