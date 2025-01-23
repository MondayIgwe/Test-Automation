package org.web.qa.playwrightWithTestNg.events;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.nio.file.Paths;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.setDefaultAssertionTimeout;

public class CommonEvents {
    Page page;

    public CommonEvents(Page page) {
        this.page = page;
    }

    public Locator findLocator(String locator) {
        return page.locator(locator);
    }

    public Locator findLocatorById(String value) {
        return page.getByTestId(value);
    }

    public Locator findLocatorByPlaceholder(String value) {
        if (value != null) {
            setTimeout(200);
            return page.getByPlaceholder(value);
        }
        setTimeout(200);
        return null;
    }

    public Locator findLocatorByLabel(String value) {
        return page.getByLabel(value);
    }

    public Locator findLocatorByText(String text) {
        return page.getByText(text);
    }

    public void onPageLoad() {
        System.out.println("Page loaded: " + page.url());
    }

    public void setTimeout(int timeout) {
        try {
            setDefaultAssertionTimeout(timeout);
        } catch (Exception e) {
            page.waitForTimeout(timeout);
        }
    }

    public boolean isEnabled(String selector) {
        Locator locator = findLocator(selector);
        if (locator.isEnabled()) {
            assertThat(locator).isEnabled(new LocatorAssertions.IsEnabledOptions().setEnabled(true));
            return true;
        }
        return false;
    }

    public void isVisible(String selector) {
        Locator locator = findLocator(selector);
        assertThat(locator).isVisible(new LocatorAssertions.IsVisibleOptions()
                .setVisible(true));
    }

    public void hasAttribute(String selector) {
        Locator locator = findLocator(selector);
        assertThat(locator).hasAttribute("disabled", String.valueOf(false));
    }

    public void takeScreenshot() {
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./report/screenshot.png")));
    }


    public void clickByLocator(String selector) {
        Locator.ClickOptions clickOptions = new Locator.ClickOptions();
        clickOptions.force = true;
        clickOptions.clickCount = 1;
        clickOptions.delay = 20.1;

        List<Locator> allLocators = findLocator(selector).all();
        if (allLocators.isEmpty()) {
            throw new RuntimeException("No matching locators found for " + selector);
        } else {
            for (Locator locator : allLocators) {
                Locator.WaitForOptions wait = new Locator.WaitForOptions();
                wait.state = WaitForSelectorState.VISIBLE;
                wait.setState(WaitForSelectorState.ATTACHED);
                locator.waitFor(wait);
                locator.first().click(clickOptions);
                break;
            }
        }
    }

    public void clickByText(String text) {
        Locator.ClickOptions clickOptions = new Locator.ClickOptions();
        clickOptions.force = true;
        clickOptions.clickCount = 1;
        clickOptions.delay = 20.1;
        findLocatorByText(text).click(clickOptions);
    }

    public void typeByLocator(String locator, String text) {
        if (findLocator(locator).isEnabled()) {
            findLocator(locator).fill(text);
            setTimeout(3000);
        }
    }

    public void typeById(String value, String text) {
        if (findLocatorById(value).isEnabled()) {
            findLocatorById(value).fill(text);
            setTimeout(3000);
        }
    }

    public void typeByPlaceHolder(String placeholderAttribute, String text) {
        if (findLocatorByPlaceholder(placeholderAttribute).isEnabled()) {
            findLocatorByPlaceholder(placeholderAttribute).fill(text);
            setTimeout(3000);
        }
    }
}
