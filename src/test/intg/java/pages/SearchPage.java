package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage {
    private String path = "/search.jsp";

    public void open(FirefoxDriver driver) {
        driver.get(buildUrl(path));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public SearchResultPage search(FirefoxDriver driver, String keyword) {
        WebElement searchKeyword = driver.findElementByXPath("/html/body/center/table/tbody/tr[3]/td/table/tbody/tr/td[2]/font/form/table/tbody/tr[1]/td[2]/input");
        searchKeyword.sendKeys(keyword);

        WebElement searchButton = driver.findElementByXPath("/html/body/center/table/tbody/tr[3]/td/table/tbody/tr/td[2]/font/form/table/tbody/tr[2]/td[2]/input");
        searchButton.submit();

        return new SearchResultPage(driver);
    }
}
