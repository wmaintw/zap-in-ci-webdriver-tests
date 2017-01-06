package common;

import com.google.gson.JsonObject;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.Boolean.valueOf;
import static java.lang.System.getProperty;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class WebDriverTestBase {
    protected FirefoxDriver driver;
    private static final String DEFAULT_GECKODRIVER_ON_MAC = "/Users/wma/develop/security/zap ci/drivers/geckodriver-mac";
    private static final String BASE_URL = "baseUrl";
    private static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
    private static final String ZAP_PROXY_ENABLED = "zapProxyEnabled";
    private static final String ZAP_PROXY_HOST = "zapProxyHost";
    private static final String ZAP_PROXY_PORT = "zapProxyPort";

    @Before
    public void setUp() throws Exception {
        initiateWebDriverSettings();
        printDebugInfo();

        driver = new FirefoxDriver(getDefaultService(), getDesiredFirefoxCapabilities(), getCapabilitiesWithProxySettings());
    }

    private void initiateWebDriverSettings() {
        String driverPath = getProperty(WEBDRIVER_GECKO_DRIVER);
        if (isEmpty(driverPath)) {
            System.setProperty(WEBDRIVER_GECKO_DRIVER, DEFAULT_GECKODRIVER_ON_MAC);
        }
    }

    private void printDebugInfo() {
        System.out.println("*********************************************");
        System.out.println("Geckodriver: " + getProperty(WEBDRIVER_GECKO_DRIVER));
        System.out.println("Base URL: " + getProperty(BASE_URL));
        System.out.println("Enable ZAP Proxy: " + valueOf(getProperty(ZAP_PROXY_ENABLED)));
        System.out.println("*********************************************");
    }

    private GeckoDriverService getDefaultService() {
        return new GeckoDriverService.Builder().build();
    }

    private DesiredCapabilities getDesiredFirefoxCapabilities() {
        return DesiredCapabilities.firefox();
    }

    private DesiredCapabilities getCapabilitiesWithProxySettings() {
        DesiredCapabilities requiredCapabilities = new DesiredCapabilities();

        if (valueOf(getProperty(ZAP_PROXY_ENABLED))) {
            JsonObject proxyJson = new JsonObject();
            proxyJson.addProperty("proxyType", "manual");
            proxyJson.addProperty("httpProxy", getProperty(ZAP_PROXY_HOST));
            proxyJson.addProperty("httpProxyPort", Integer.valueOf(getProperty(ZAP_PROXY_PORT)));
            requiredCapabilities.setCapability(CapabilityType.PROXY, proxyJson);
        }

        return requiredCapabilities;
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }
}
