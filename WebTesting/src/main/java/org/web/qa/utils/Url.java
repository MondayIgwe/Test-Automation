package org.web.qa.utils;

public enum Url {
    PRACTICE_SOFTWARE_TESTING("https://practicesoftwaretesting.com/"),
    TEST_AUTOMATION_PRACTICE("https://testautomationpractice.blogspot.com/"),
    FREELANCE_LEARN_AUTOMATION("https://freelance-learn-automation.vercel.app/login");

    private final String url;

    Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
