package base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static base.CreateDriver.driver;
import static org.testng.Assert.assertNotNull;

public class WebDriverFactory {

    static String url = "https://www.ebay.com/";
    static ChromeOptions options;
    static EdgeOptions edgeOptions;

    @BeforeClass
    public static void setupChromeDriver() {
        System.out.println("Starting Chrome");
    }

    public static void setup(String browserName) {
        switch (browserName) {
            case "chrome":
                Proxy proxy = new Proxy();
                proxy.setHttpProxy("organisationhttpproxy:3337");
                options.setCapability("proxy", proxy);

                options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.addArguments("--remote-allow-origins=*");
                options.setExperimentalOption("excludeSwitches",
                        Arrays.asList("disable-popup-blocking"));

                Map<String, Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", "/directory/path");
                options.setExperimentalOption("prefs", prefs);
                assertNotNull(options);
                assertNotNull(driver);

                CreateDriver.getInstance().setDriverChrome(options);
                CreateDriver.getInstance().getDriver().get(url);
                break;
            case "edge":
                edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                CreateDriver.getInstance().setDriverEdge();
                CreateDriver.getInstance().getDriver().get(url);

                EdgeDriverService service = new EdgeDriverService.Builder().withLogOutput(System.out).build();
                System.out.println(service);
                System.out.println(service.getDriverProperty());
                Capabilities capabilities = service.getDefaultDriverOptions();
                Set<String> capabilitiesSet = capabilities.getCapabilityNames();
                for (String capability : capabilitiesSet) {
                    System.out.println("Capability " + capability);
                }
                break;
            default:
                System.out.println("Invalid browser");

        }
    }
    @AfterClass
    public static void tearDown() {
        System.out.println("Closing Chrome");
        System.out.println("Clean up resources");
        CreateDriver.getInstance().getDriver().quit();
    }
}
