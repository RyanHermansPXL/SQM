package integration;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import postcodesio.models.body.PostcodesBody;
import postcodesio.serviceObjects.AllServices;

public class TestReverseGeocoding {
    private AllServices postcodeServices;

    @BeforeClass
    public void setup() {
        postcodeServices = new AllServices();
    }

    @Test
    public void UseReverseGeocodingWithBody() {
        JSONArray body = new JSONArray();
        JSONObject firstArrayItem = new JSONObject();
        JSONObject secondArrayItem = new JSONObject();

        firstArrayItem.put("longitude", "-1.069752");
        firstArrayItem.put("latitude", "51.655929");
        body.add(firstArrayItem);

        secondArrayItem.put("longitude", "-2.49690382054704");
        secondArrayItem.put("latitude", "53.5351312861402");
        body.add(secondArrayItem);


        PostcodesBody response = postcodeServices.reverseGeocoding.getReverseGeocoding(body);
        Assert.assertEquals(response.status, 200);
    }

    @Test
    public void UseReverseGeocodingWithWrongBody() {
        JSONArray body = new JSONArray();
        JSONObject firstArrayItem = new JSONObject();
        firstArrayItem.put("test", "-1.069752");
        body.add(firstArrayItem);

        PostcodesBody response = postcodeServices.reverseGeocoding.getReverseGeocoding(body);
        Assert.assertEquals(response.status, 400);
    }
}
