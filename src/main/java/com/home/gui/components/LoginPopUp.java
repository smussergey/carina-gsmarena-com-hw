package com.home.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.home.gui.pages.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
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
    private ExtendedWebElement logInButton;

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

    public boolean doesEmailInputTextFieldIntractable() {
        emailInputTextField.type("");
        return true;
    }

    public void enterEmail(String email) {
        LOGGER.info("Email = {}", email);
        emailInputTextField.type(email);
    }

    public boolean isPasswordInputTextFieldPresent() {
        return passwordInputTextField.isPresent();
    }

    public boolean doesPasswordInputTextFieldIntractable() {
        passwordInputTextField.type("");
        return true;
    }

    public void enterPassword(String password) {
        LOGGER.info("Password = {}", password);
        passwordInputTextField.type(password);
    }

    public boolean isLogInButtonPresent() {
        return logInButton.isPresent();
    }


    public boolean isLogInButtonClickable() {
        return logInButton.isClickable();
    }

    public void hooverLogInButton() {
        logInButton.hover();
    }

    public String getLogInButtonColor() {
        logInButton.pause(1);
        return (String) ((JavascriptExecutor) driver).executeScript("return window" +
                ".getComputedStyle(document.getElementById('nick-submit')).getPropertyValue('background')");
    }

    public LoginPage submitForm() {
        logInButton.click();
        return new LoginPage(driver);
    }

    public boolean isIForgotMyPasswordButtonPresent() {
        return iForgotMyPasswordButton.isPresent();
    }

    public boolean isIForgotMyPasswordButtonClickable() {
        return iForgotMyPasswordButton.isClickable();
    }


}
