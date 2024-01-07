package integration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import postcodesio.models.body.OutcodeBody;
import postcodesio.models.body.PostcodeBody;
import postcodesio.serviceObjects.AllServices;

public class TestLookupOutcode {
    private AllServices postcodeServices;

    @BeforeClass
    public void setup() {
        postcodeServices = new AllServices();
    }

    @Test
    public void LookupOutcodeWithParameter() {

        OutcodeBody response = postcodeServices.lookupOutcode.getLookupOutcode("OX49");
        Assert.assertEquals(response.status, 200);
    }

    @Test
    public void LookupOutcodeWithoutParameter() {

        OutcodeBody response = postcodeServices.lookupOutcode.getLookupOutcode("");
        Assert.assertEquals(response.status, 400);
    }

    @Test
    public void LookupOutcodeWithWrongParameter() {

        OutcodeBody response = postcodeServices.lookupOutcode.getLookupOutcode("1");
        Assert.assertEquals(response.status, 404);
    }
}
