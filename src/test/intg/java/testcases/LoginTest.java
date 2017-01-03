package testcases;

import common.WebDriverTestBase;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;
import pages.LoginPage;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LoginTest extends WebDriverTestBase {
    @Test
    public void shouldLoginToDashboardSuccessfully() throws Exception {
        LoginPage loginPage = new LoginPage();

        loginPage.open(driver);

        String username = "test1@163.com";
        String password = "abc123";
        DashboardPage dashboardPage = loginPage.login(driver, username, password);

        WebElement profileLink = dashboardPage.getProfileLink();
        assertThat(profileLink.getText(), is(username));
    }
}
