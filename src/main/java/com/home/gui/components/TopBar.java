package com.home.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.home.gui.pages.SignUpPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TopBar extends AbstractUIObject {
    @FindBy(xpath = "//a[contains(@class, 'signup-icon')]")
    private ExtendedWebElement signUpButton;

    @FindBy(id = "login-active")
    private ExtendedWebElement loginButton;

    @FindBy(id = "login-popup2")
    private LoginPopUp loginPopUp;

    public TopBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public SignUpPage openSignUpPage() {
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public LoginPopUp openLoginPopUp() {
        loginButton.click();
        return loginPopUp;
    }

}
