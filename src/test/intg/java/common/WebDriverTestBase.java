package common;

import com.google.gson.JsonObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverTestBase {
    protected FirefoxDriver driver;
    private static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";

    @Before
    public void setUp() throws Exception {

        String driverPath = System.getProperty(WEBDRIVER_GECKO_DRIVER);
        if (StringUtils.isEmpty(driverPath)) {
            System.setProperty(WEBDRIVER_GECKO_DRIVER, "/Users/wma/develop/security/zap ci/drivers/geckodriver");
        }

        System.out.println("*********************************************");
        System.out.println("Geckodriver: " + System.getProperty(WEBDRIVER_GECKO_DRIVER));
        System.out.println("Base URL: " + System.getProperty("baseUrl"));
        System.out.println("*********************************************");

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
