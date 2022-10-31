package com.solvd.gsmarena.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.gsmarena.gui.pages.LoginPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LoginPopUp extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//span[@id='login-popup2']//p[contains(text(), 'Login')]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//span[@id='login-popup2']//input[@id='email']")
    private ExtendedWebElement emailInputTextField;

    @FindBy(xpath = "//span[@id='login-popup2']//input[@id='upass']")
    private ExtendedWebElement passwordInputTextField;

    @FindBy(xpath = "//span[@id='login-popup2']//input[@id='nick-submit']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//a[@class='forgot']")
    private ExtendedWebElement iForgotMyPasswordButton;

    public LoginPopUp(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isTitlePresent() {
        return title.isPresent();
    }

    public String readTitleText() {
        return title.getText();
    }

    public boolean isEmailInputTextFieldPresent() {
        return emailInputTextField.isPresent();
    }

    public boolean isEmailInputTextFieldIntractable(String text) {
        emailInputTextField.type(text);
        emailInputTextField.getElement().clear();
        return true;
    }

    public void typeEmail(String email) {
        LOGGER.info("Email = {}", email);
        emailInputTextField.type(email);
    }

    public boolean isPasswordInputTextFieldPresent() {
        return passwordInputTextField.isPresent();
    }

    public boolean isPasswordInputTextFieldIntractable(String text) {
        passwordInputTextField.type(text);
        passwordInputTextField.getElement().clear();
        return true;
    }

    public void typePassword(String password) {
        LOGGER.info("Password = {}", password);
        passwordInputTextField.type(password);
    }

    public boolean isLogInButtonPresent() {
        return loginButton.isPresent();
    }


    public boolean isLogInButtonClickable() {
        return loginButton.isClickable();
    }

    public void hoverLoginButton() {
        loginButton.hover();
    }

    public String getLoginButtonColor() {
        loginButton.pause(1);
    return loginButton.getElement().getCssValue("background");
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }

    public boolean isIForgotMyPasswordButtonPresent() {
        return iForgotMyPasswordButton.isPresent();
    }

    public boolean isIForgotMyPasswordButtonClickable() {
        return iForgotMyPasswordButton.isClickable();
    }

    public String getEmailErrorMessage() {
        return emailInputTextField.getAttribute("validationMessage");
    }

    public String getPasswordErrorMessage() {
        return passwordInputTextField.getAttribute("validationMessage");
    }

}
