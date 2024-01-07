package postcodesio.serviceObjects;

public class AllServices {
    public RandomPostcode randomPostcode;
    public LookupPostcodes lookupPostcodes;
    public LookupPostcode lookupPostcode;
    public PostcodeLonLat postcodeLonLat;
    public ReverseGeocoding reverseGeocoding;
    public ValidatePostcode validatePostcode;
    public LookupOutcode lookupOutcode;
    public OutcodeLonLat outcodeLonLat;

    public AllServices() {
        this.randomPostcode = new RandomPostcode();
        this.lookupPostcodes = new LookupPostcodes();
        this.lookupPostcode = new LookupPostcode();
        this.postcodeLonLat = new PostcodeLonLat();
        this.reverseGeocoding = new ReverseGeocoding();
        this.validatePostcode = new ValidatePostcode();
        this.lookupOutcode = new LookupOutcode();
        this.outcodeLonLat = new OutcodeLonLat();
    }
}
