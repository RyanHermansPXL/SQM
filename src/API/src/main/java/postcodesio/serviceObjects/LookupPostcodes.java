package postcodesio.serviceObjects;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import postcodesio.models.Postcode;
import postcodesio.models.body.PostcodesBody;

import java.util.ArrayList;

public class LookupPostcodes extends BaseService{
    public LookupPostcodes() {
        super("postcodes");
    }

    public Response lookupPostcodesResponse(ArrayList postcodes) {
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();

        requestParams.put("postcodes", postcodes);

        request.body(requestParams.toJSONString());
        request.contentType(ContentType.JSON);
        request.baseUri(this.baseUrl + this.endpoint);
        request.header("Content-Type", "application/json");

        Response response = request.post();
        return response;
    }

    public PostcodesBody lookupPostcodes(ArrayList postcodes) {
        return Postcode.getPostcodes(this.lookupPostcodesResponse(postcodes));
    }

    public Response lookupPostcodesFailResponse() {
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();

        request.body(requestParams.toJSONString());
        request.contentType(ContentType.JSON);
        request.baseUri(this.baseUrl + this.endpoint);
        request.header("Content-Type", "application/json");

        Response response = request.post();
        return response;
    }

    public PostcodesBody lookupPostcodesFail() {
        return Postcode.getPostcodes(this.lookupPostcodesFailResponse());
    }


}
