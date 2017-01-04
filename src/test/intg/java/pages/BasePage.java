package pages;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class BasePage {
    protected String defaultBaseUrl = "http://security.local:8282/bodgeit";

    protected String buildUrl(String path) {
        return getBaseUrl() + path;
    }

    private String getBaseUrl() {
        String baseUrl = System.getProperty("baseUrl");
        return isEmpty(baseUrl) ? defaultBaseUrl : baseUrl;
    }
}
