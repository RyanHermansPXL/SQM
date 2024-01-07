package postcodesio.serviceObjects;

import io.restassured.response.Response;
import postcodesio.models.Outcode;
import postcodesio.models.body.OutcodeBody;

import static io.restassured.RestAssured.when;

public class LookupOutcode extends BaseService {
    public LookupOutcode() {
        super("outcodes");
    }

    public Response lookupOutcodeResponse(String outcode) {
        return when().get(this.baseUrl + this.endpoint+ "/" + outcode);
    }

    public OutcodeBody getLookupOutcode(String outcode) {
        return Outcode.getOutcode(this.lookupOutcodeResponse(outcode));
    }
}
