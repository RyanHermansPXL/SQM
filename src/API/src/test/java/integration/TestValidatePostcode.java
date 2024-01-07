package integration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import postcodesio.models.body.PostcodeBody;
import postcodesio.models.body.ValidatePostcodeBody;
import postcodesio.serviceObjects.AllServices;

public class TestValidatePostcode {
    private AllServices postcodeServices;

    @BeforeClass
    public void setup() {
        postcodeServices = new AllServices();
    }

    @Test
    public void ValidatePostcodeWithParameter() {

        ValidatePostcodeBody response = postcodeServices.validatePostcode.getValidatePostcode("OX495NU");
        Assert.assertTrue(response.result);
    }
    @Test
    public void ValidatePostcodeWithoutParameter() {

        ValidatePostcodeBody response = postcodeServices.validatePostcode.getValidatePostcode("");
        Assert.assertEquals(response.status, 404);
    }

    @Test
    public void ValidatePostcodeWithWrongParameter() {
        ValidatePostcodeBody response = postcodeServices.validatePostcode.getValidatePostcode("1");
        Assert.assertFalse(response.result);
    }
}
