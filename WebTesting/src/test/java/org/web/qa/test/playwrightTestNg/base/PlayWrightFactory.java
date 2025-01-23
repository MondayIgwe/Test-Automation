package org.web.qa.test.playwrightTestNg.base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.web.qa.playwrightWithTestNg.Events.CommonEvents;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.web.qa.utils.ReadProperty.QA;
import static org.web.qa.utils.ReadProperty.getProperty;

public abstract class PlayWrightFactory {

    public Page page;
    public Browser browser;
    public Playwright playwright;
    CommonEvents commonEvents;

    @BeforeSuite
    public void beforeSetup() throws FileNotFoundException {
        getProperty("src/main/resources/config/config.property");
        playwright = Playwright.create();
    }

    @Parameters({"testBrowser"})
    @BeforeMethod
    public void setup(@Optional String testBrowser) {

        switch (testBrowser) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
                break;
            case "msedge":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge"));
                break;
            case "safari":
                browser = playwright.webkit().launch();
                break;
            default:
                System.out.println("Invalid browser name. Supported browsers are: chrome, webkit, firefox, chrome-canary, edge-beta, edge-dev, safari");
                return;
        }

        page = browser.newPage();
        page.navigate(QA);
        commonEvents = new CommonEvents(page);

        // get the title of the page
        String title = page.title();
        System.out.println(title);

        // take a screenshot of the page
        commonEvents.takeScreenshot();

        //Expect a title to contain a substring
        assertThat(page).hasTitle(Pattern.compile(title));
        assertThat(page).hasURL(QA);
    }

//    @AfterMethod
//    public void tearDown() {
//        if (playwright != null) {
//            page.close();
//            browser.close();
//            playwright.close();
//        }
//    }
}
