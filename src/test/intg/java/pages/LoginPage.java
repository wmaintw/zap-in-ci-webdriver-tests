package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {
    private String path = "/login.jsp";

    public void open(FirefoxDriver driver) {
        driver.get(buildUrl(path));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public DashboardPage login(FirefoxDriver driver, String username, String password) throws InterruptedException {
        WebElement usernameField = driver.findElementById("username");
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElementById("password");
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElementByXPath("//*[@id=\"submit\"]");
        loginButton.click();
        return new DashboardPage(driver);
    }
}
