package pages;

public class BasePage {
    protected String baseUrl = "http://security.local:8282/bodgeit";

    protected String buildUrl(String path) {
        return baseUrl + path;
    }
}
