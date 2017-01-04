package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DashboardPage extends BasePage {

    private FirefoxDriver driver;

    public DashboardPage(FirefoxDriver driver) throws InterruptedException {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public WebElement getProfileLink() {
        return getProfileLink(this.driver);
    }

    public WebElement getProfileLink(FirefoxDriver driver) {
        return driver.findElementByXPath("/html/body/center/table/tbody/tr[1]/td/table/tbody/tr/td[3]/a");
    }
}
