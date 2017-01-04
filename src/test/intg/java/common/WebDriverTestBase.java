package common;

import com.google.gson.JsonObject;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class WebDriverTestBase {
    protected FirefoxDriver driver;

    @Before
    public void setUp() throws Exception {
        JsonObject proxyJson = new JsonObject();
        proxyJson.addProperty("proxyType", "manual");
        proxyJson.addProperty("httpProxy", "127.0.0.1");
        proxyJson.addProperty("httpProxyPort", 7070);

        DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
        DesiredCapabilities requiredCapabilities = new DesiredCapabilities();
        requiredCapabilities.setCapability(CapabilityType.PROXY, proxyJson);
        GeckoDriverService service = new GeckoDriverService.Builder().build();
        driver = new FirefoxDriver(service, desiredCapabilities, requiredCapabilities);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }
}
