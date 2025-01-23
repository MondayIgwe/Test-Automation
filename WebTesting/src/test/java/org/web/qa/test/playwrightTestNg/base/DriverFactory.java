package org.web.qa.test.playwrightTestNg.base;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public abstract class DriverFactory {
    public static ThreadLocal<Page> currentPage = new ThreadLocal<>();
    public Page page = null;
    public Browser browser;
    public Playwright playwright;

    public Page getPage(String browserName) {

        playwright = Playwright.create();
        if (browserName.equalsIgnoreCase("Chrome")) {
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            page = browser.newPage();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            browser = playwright.firefox().launch();
            page = browser.newPage();
        } else if (browserName.equalsIgnoreCase("edge")) {
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge"));
            page = browser.newPage();
        } else if (browserName.equalsIgnoreCase("safari")) {
            browser = playwright.webkit().launch();
            page = browser.newPage();
        }

        System.out.println("Page ID " + page);
        return page;
    }
}

