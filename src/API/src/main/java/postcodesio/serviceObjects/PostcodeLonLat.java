package postcodesio.serviceObjects;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import postcodesio.models.Postcode;
import postcodesio.models.body.PostcodesBody;

import static io.restassured.RestAssured.when;

public class PostcodeLonLat extends BaseService{
    public PostcodeLonLat() {
        super("postcodes");
    }

    public Response postcodeLonLatResponse(String longitude, String latitude) {
        return when().get(this.baseUrl + this.endpoint+ "?lon=" + longitude + "&lat=" + latitude);
    }

    public PostcodesBody getPostcodeLongLat(String longitude, String latitude) {
        return Postcode.getPostcodes(this.postcodeLonLatResponse(longitude, latitude));
    }
}
