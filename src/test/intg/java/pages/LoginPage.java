package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage {
    private String url = "http://127.0.0.1:8282/bodgeit/login.jsp";

    public void open(FirefoxDriver driver) {
        driver.get(url);
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
