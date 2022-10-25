package com.home.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


public class SignUpPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final String signUpPageUrl = "https://www.gsmarena.com/register.php3";

    @FindBy(id = "uname")
    private ExtendedWebElement nickNameInputTextField;

    @FindBy(xpath = "//div[@id='user-submit']//input[@id='email']")
    private ExtendedWebElement emailInputTextField;

    @FindBy(xpath = "//div[@id='user-submit']//input[@id='upass']")
    private ExtendedWebElement passwordInputTextField;

    @FindBy(xpath = "//label[@for='iagree1']")
    private ExtendedWebElement conformationForStoreDataCheckBox;

    @FindBy(xpath = "//label[@for='iagree2']")
    private ExtendedWebElement conformationForAgeCheckBox;

    @FindBy(xpath = "//div[@id='user-submit']//input[@id='nick-submit']")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//div[contains(@class, 'res-success')]/*[contains (text(), 'Your account was created.')]")
    private ExtendedWebElement successfulRegistrationTextField;

    public SignUpPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(signUpPageUrl);
    }

    public void enterNickName(String nickName) {
        LOGGER.info("NickName = {}", nickName);
        nickNameInputTextField.type(nickName);
    }

    public void enterEmail(String email) {
        LOGGER.info("Email = {}", email);
        emailInputTextField.type(email);
    }

    public void enterPassword(String passWord) {
        LOGGER.info("PassWord = {}", passWord);
        passwordInputTextField.type(passWord);
    }

    public void selectConformationForStoreData() {
        conformationForStoreDataCheckBox.click();
    }

    public void selectConformationForAge() {
        conformationForAgeCheckBox.click();
    }

    public void submitForm() {
        if (submitButton.isClickable()) {
            submitButton.click();
        } else {
            throw new RuntimeException("Submit button is not clickable, check input fields");
        }
    }

    public boolean isSuccessfulRegistrationConfirmationAnnouncementVisible() {
        return successfulRegistrationTextField.isVisible();
    }

}
