package postcodesio.serviceObjects;

import io.restassured.response.Response;
import postcodesio.models.Postcode;
import postcodesio.models.body.PostcodeBody;
import postcodesio.models.body.ValidatePostcodeBody;

import static io.restassured.RestAssured.when;

public class ValidatePostcode extends BaseService{
    public ValidatePostcode() {
        super("postcodes");
    }

    public Response validatePostcodeResponse(String postcode) {
        return when().get(this.baseUrl + this.endpoint+ "/" + postcode +"/validate");
    }

    public ValidatePostcodeBody getValidatePostcode(String postcode) {
        return Postcode.getValidatePostcode(this.validatePostcodeResponse(postcode));
    }
}
