package postcodesio.serviceObjects;

import io.restassured.response.Response;
import postcodesio.models.Postcode;
import postcodesio.models.body.PostcodeBody;
import postcodesio.models.body.PostcodesBody;

import static io.restassured.RestAssured.when;

public class LookupPostcode extends BaseService{
    public LookupPostcode() {
        super("postcodes");
    }

    public Response lookupPostcodeResponse(String postcode) {
        return when().get(this.baseUrl + this.endpoint+ "/" + postcode);
    }

    public PostcodeBody getLookupPostcode(String postcode) {
        return Postcode.getPostcode(this.lookupPostcodeResponse(postcode));
    }


}
