package testcases;

import common.WebDriverTestBase;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.SearchPage;
import pages.SearchResultPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class SearchTest extends WebDriverTestBase {
    @Test
    public void shouldSearchSomething() throws Exception {
        SearchPage searchPage = new SearchPage();
        searchPage.open(driver);
        SearchResultPage searchResultPage = searchPage.search(driver, "ba");

        WebElement searchResult = searchResultPage.getSearchResult();
        assertThat(searchResult.getText(), is(notNullValue()));
    }
}
