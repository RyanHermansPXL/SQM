package postcodesio.models;

import io.restassured.response.Response;
import postcodesio.models.body.OutcodeBody;
import postcodesio.models.body.OutcodesBody;

import java.util.ArrayList;

public class Outcode extends BaseModel{
    public String outcode;
    public double longitude;
    public double latitude;
    public int northings;
    public int eastings;
    public ArrayList<String> admin_district;
    public ArrayList<String> parish;
    public ArrayList<String> admin_county;
    public ArrayList<String> admin_ward;
    public ArrayList<String> country;
    public ArrayList<String> parliamentary_constituency;


    public static OutcodeBody getOutcode(Response response){

        return gson.fromJson(response.body().asString(), OutcodeBody.class);
    }

    public static OutcodesBody getOutcodes(Response response){

        return gson.fromJson(response.body().asString(), OutcodesBody.class);
    }
}
