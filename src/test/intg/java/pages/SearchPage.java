package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchPage {
    private String url = "http://127.0.0.1:8282/bodgeit/search.jsp";

    public void open(FirefoxDriver driver) {
        driver.get(url);
    }

    public SearchResultPage search(FirefoxDriver driver, String keyword) {
        WebElement searchKeyword = driver.findElementByXPath("/html/body/center/table/tbody/tr[3]/td/table/tbody/tr/td[2]/font/form/table/tbody/tr[1]/td[2]/input");
        searchKeyword.sendKeys(keyword);

        WebElement searchButton = driver.findElementByXPath("/html/body/center/table/tbody/tr[3]/td/table/tbody/tr/td[2]/font/form/table/tbody/tr[2]/td[2]/input");
        searchButton.submit();

        return new SearchResultPage(driver);
    }
}
