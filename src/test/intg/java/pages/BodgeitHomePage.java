package pages;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BodgeitHomePage {

    private String url = "http://127.0.0.1:8282/bodgeit";

    public void open(FirefoxDriver driver) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public String getTitle(FirefoxDriver driver) {
        return driver.getTitle();
    }
}
