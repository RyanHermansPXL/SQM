package integration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import postcodesio.models.body.OutcodeBody;
import postcodesio.models.body.OutcodesBody;
import postcodesio.models.body.PostcodesBody;
import postcodesio.serviceObjects.AllServices;
import postcodesio.serviceObjects.OutcodeLonLat;

public class TestGetOutcodeLonLat {
    private AllServices postcodeServices;

    @BeforeClass
    public void setup() {
        postcodeServices = new AllServices();
    }

    @Test
    public void LookupOutcodeWithParameter() {
        OutcodesBody response = postcodeServices.outcodeLonLat.getOutcodeLongLat("-1.00196028193833", "51.6504579911894");
        Assert.assertEquals(response.status, 200);
    }

    @Test
    public void LookupOutcodeWithoutParameter() {
        OutcodesBody response = postcodeServices.outcodeLonLat.getOutcodeLongLat("","");
        Assert.assertEquals(response.status, 400);
    }
}
