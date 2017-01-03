package testcases;

import common.WebDriverTestBase;
import org.junit.Before;
import org.junit.Test;
import pages.BodgeitHomePage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HomePageTest extends WebDriverTestBase {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldOpenHomePage() throws Exception {
        BodgeitHomePage homePage = new BodgeitHomePage();
        assertThat(homePage.getTitle(driver), is("The BodgeIt Store"));
    }
}
