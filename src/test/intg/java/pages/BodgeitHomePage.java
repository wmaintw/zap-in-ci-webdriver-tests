package pages;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BodgeitHomePage extends BasePage {

    private String path = "/";

    public void open(FirefoxDriver driver) {
        driver.get(buildUrl(path));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public String getTitle(FirefoxDriver driver) {
        return driver.getTitle();
    }
}
