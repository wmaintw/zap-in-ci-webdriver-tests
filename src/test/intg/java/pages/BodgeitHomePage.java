package pages;

import org.openqa.selenium.firefox.FirefoxDriver;

public class BodgeitHomePage {

    private static String PAGE_TITLE = "The BodgeIt Store";
    private String url = "http://127.0.0.1:8282/bodgeit";

    public void open(FirefoxDriver driver) {
        driver.get(url);
    }

    public String getTitle(FirefoxDriver driver) {
        open(driver);
        return driver.getTitle();
    }
}
