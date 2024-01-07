package postcodesio.serviceObjects;

import io.restassured.response.Response;
import postcodesio.models.Outcode;
import postcodesio.models.body.OutcodeBody;
import postcodesio.models.body.OutcodesBody;
import postcodesio.models.body.PostcodesBody;

import static io.restassured.RestAssured.when;

public class OutcodeLonLat extends BaseService {
    public OutcodeLonLat() {
        super("outcodes");
    }

    public Response outcodesLonLatResponse(String longitude, String latitude) {
        return when().get(this.baseUrl + this.endpoint+ "?lon=" + longitude + "&lat=" + latitude);
    }

    public OutcodesBody getOutcodeLongLat(String longitude, String latitude) {
        return Outcode.getOutcodes(this.outcodesLonLatResponse(longitude, latitude));
    }
}
