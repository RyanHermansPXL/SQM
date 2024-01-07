package postcodesio.serviceObjects;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import postcodesio.models.Postcode;
import postcodesio.models.body.PostcodesBody;

public class ReverseGeocoding extends BaseService{
    public ReverseGeocoding() {
        super("postcodes");
    }

    public Response reverseGeocodingResponse(JSONArray postObject) {
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();

        requestParams.put("geolocations", postObject);

        request.body(requestParams.toJSONString());
        request.contentType(ContentType.JSON);
        request.baseUri(this.baseUrl + this.endpoint);
        request.header("Content-Type", "application/json");

        return request.post();
    }

    public PostcodesBody getReverseGeocoding(JSONArray postObject) {
        return Postcode.getPostcodes(this.reverseGeocodingResponse(postObject));
    }

}
