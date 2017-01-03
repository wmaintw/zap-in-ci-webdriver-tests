package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SearchResultPage {
    private FirefoxDriver driver;

    public SearchResultPage() {
    }

    public SearchResultPage(FirefoxDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public WebElement getSearchResult() {
        return getSearchResult(this.driver);
    }

    public WebElement getSearchResult(FirefoxDriver driver) {
        return driver.findElementByXPath("/html/body/center/table/tbody/tr[3]/td/table");
    }
}
