package common;

import com.google.gson.JsonObject;
import com.sun.jna.platform.win32.WinBase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverTestBase {
    protected FirefoxDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "/Users/wma/develop/common-used-components/geckodriver");

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
