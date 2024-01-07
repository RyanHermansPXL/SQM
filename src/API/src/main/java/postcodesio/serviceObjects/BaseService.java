package postcodesio.serviceObjects;

public class BaseService {
    protected String baseUrl = "https://api.postcodes.io/";
    protected String endpoint;

    public BaseService(String endpoint) {
        this.endpoint = endpoint;
    }
}
