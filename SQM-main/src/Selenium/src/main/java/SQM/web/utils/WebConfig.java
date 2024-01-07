package SQM.web.utils;

import SQM.common.JSONhelper;

import java.time.Duration;

public class WebConfig {
    private static final String webConfigJsonFile = "src/main/java/SQM/web/webConfig.json";
    public static String getDefaultBrowser(){
        String defaultDefaultBrowser = JSONhelper.getJSONStringFromJsonFile(webConfigJsonFile, "defaultBrowser");
        String defaultBrowser = System.getenv("DEFAULT_BROWSER");
        return (defaultBrowser != null) ? defaultBrowser : defaultDefaultBrowser;
    }

    public static String getBaseUrl() {
        String defaultTestUrl = JSONhelper.getJSONStringFromJsonFile(webConfigJsonFile, "baseURL");
        String testUrl = System.getenv("TEST_URL");
        return (testUrl != null) ? testUrl : defaultTestUrl;
    }

    public static Duration getDefaultWait() {
        return Duration.ofSeconds(10);
    }
}
