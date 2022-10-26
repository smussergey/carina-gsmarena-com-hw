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
    private ExtendedWebElement IAgreeForGSMArenaToStoreMyCheckbox;

    @FindBy(xpath = "//label[@for='iagree2']")
    private ExtendedWebElement IAmAtLeast16YearsOldCheckbox;

    @FindBy(xpath = "//div[@id='user-submit']//input[@id='nick-submit']")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//div[contains(@class, 'res-success')]//h3[contains (text(), 'Your account was created.')]")
    private ExtendedWebElement yourAccountWasCreatedTitle;

    public SignUpPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(signUpPageUrl);
    }

    public void typeNickName(String nickName) {
        LOGGER.info("NickName = {}", nickName);
        nickNameInputTextField.type(nickName);
    }

    public void typeEmail(String email) {
        LOGGER.info("Email = {}", email);
        emailInputTextField.type(email);
    }

    public void typePassword(String passWord) {
        LOGGER.info("PassWord = {}", passWord);
        passwordInputTextField.type(passWord);
    }

    public void checkIAgreeForGSMArenaToStore() {
        IAgreeForGSMArenaToStoreMyCheckbox.click();
    }

    public void checkIAmAtLeast16YearsOld() {
        IAmAtLeast16YearsOldCheckbox.click();
    }

    public void clickSubmitButton() {
            submitButton.click();
    }

    public boolean isYourAccountWasCreatedTitleVisible() {
        return yourAccountWasCreatedTitle.isVisible();
    }

}
