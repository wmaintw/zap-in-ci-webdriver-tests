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
    private static final String DEFAULT_GECKODRIVER_ON_MAC = "/Users/wma/develop/security/zap ci/drivers/geckodriver-mac";

    @Before
    public void setUp() throws Exception {
        initiateWebDriverSettings();
        printDebugInfo();

        driver = new FirefoxDriver(getDefaultService(), getDesiredFirefoxCapabilities(), getCapabilitiesWithProxySettings());
    }

    private void initiateWebDriverSettings() {
        String driverPath = System.getProperty(WEBDRIVER_GECKO_DRIVER);
        if (StringUtils.isEmpty(driverPath)) {
            System.setProperty(WEBDRIVER_GECKO_DRIVER, DEFAULT_GECKODRIVER_ON_MAC);
        }
    }

    private void printDebugInfo() {
        System.out.println("*********************************************");
        System.out.println("Geckodriver: " + System.getProperty(WEBDRIVER_GECKO_DRIVER));
        System.out.println("Base URL: " + System.getProperty("baseUrl"));
        System.out.println("*********************************************");
    }

    private GeckoDriverService getDefaultService() {
        return new GeckoDriverService.Builder().build();
    }

    private DesiredCapabilities getDesiredFirefoxCapabilities() {
        return DesiredCapabilities.firefox();
    }

    private DesiredCapabilities getCapabilitiesWithProxySettings() {
        JsonObject proxyJson = new JsonObject();
        proxyJson.addProperty("proxyType", "manual");
        proxyJson.addProperty("httpProxy", "127.0.0.1");
        proxyJson.addProperty("httpProxyPort", 7070);

        DesiredCapabilities requiredCapabilities = new DesiredCapabilities();
        requiredCapabilities.setCapability(CapabilityType.PROXY, proxyJson);
        return requiredCapabilities;
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }
}
