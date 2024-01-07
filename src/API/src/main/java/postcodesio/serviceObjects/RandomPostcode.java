package postcodesio.serviceObjects;

import io.restassured.response.Response;
import postcodesio.models.Postcode;
import postcodesio.models.body.PostcodeBody;

import static io.restassured.RestAssured.when;

public class RandomPostcode extends BaseService {
    public RandomPostcode() {
        super("random/postcodes");
    }

    public Response getRandomPostcodeResponse() {
        return when().get(this.baseUrl + this.endpoint);
    }

    public PostcodeBody getRandomPostcode() {
        return Postcode.getPostcode(this.getRandomPostcodeResponse());
    }
}
