package com.home.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    private final String loginPageUrl = "https://www.gsmarena.com/login.php3";

    @FindBy(xpath = "//div[contains(@class, 'res-success')]//h3[contains (text(), 'Login successful.')]")
    private ExtendedWebElement loginSuccessfulTitle;

    @FindBy(xpath = "//div[contains(@class, 'res-error')]//h3[contains (text(), 'Login failed.')]")
    private ExtendedWebElement loginFailedTitle;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(loginPageUrl);
    }

    public boolean isLoginSuccessfulTitleVisible() {
        return loginSuccessfulTitle.isVisible();
    }

    public boolean isLoginFailedTitleVisible() {
        return loginFailedTitle.isVisible();
    }
}
