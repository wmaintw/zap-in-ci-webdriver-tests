package testcases;

import common.WebDriverTestBase;
import org.junit.Test;
import pages.BodgeitHomePage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HomePageTest extends WebDriverTestBase {
    @Test
    public void shouldOpenHomePage() throws Exception {
        BodgeitHomePage homePage = new BodgeitHomePage();
        homePage.open(driver);
        assertThat(homePage.getTitle(driver), is("The BodgeIt Store"));
    }
}
