package com.home;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.home.gui.components.LoginPopUp;
import com.home.gui.components.TopBar;
import com.home.gui.pages.HomePage;
import com.home.gui.pages.LoginPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogInTest implements IAbstractTest {

    private static final String TEST_DATA_EMAIL = "semtestsem029@gmail.com";
    private static final String TEST_DATA_PASSWORD = "myPassword7";

    @Test(description = "Test presents, intractability of Login popup fields")
    @MethodOwner(owner = "Smus Sergii")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "smoke"})
    public void testFunctionalityOfLogInPopUpFields() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        TopBar topBar = homePage.getTopBar();
        Assert.assertTrue(topBar.isUIObjectPresent(2), "Top bar wasn't found!");

        LoginPopUp popUp = topBar.getLoginPopUp();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(popUp.isTitlePresent(), "Title is not present");
        softAssert.assertEquals(popUp.readTitleText(), "Login", "Title does not equal Login");

        softAssert.assertTrue(popUp.isEmailInputTextFieldPresent(), "Email field is not present");
        softAssert.assertTrue(popUp.isEmailInputTextFieldIntractable(), "We cannot enter text into Email field");

        softAssert.assertTrue(popUp.isPasswordInputTextFieldPresent(), "Password field is not present");
        softAssert.assertTrue(popUp.isPasswordInputTextFieldIntractable(), "We cannot enter text into Password field");

        softAssert.assertTrue(popUp.isLogInButtonPresent(), "Login button is not present");
        popUp.hoverLoginButton();
        softAssert.assertTrue(popUp.getLoginButtonColor().contains("rgb(213, 0, 0)"), "Button has different color");
        softAssert.assertTrue(popUp.isLogInButtonClickable(), "Login button is not clickable");

        softAssert.assertTrue(popUp.isIForgotMyPasswordButtonPresent(), "\"I forgot my password\" button is not present");
        softAssert.assertTrue(popUp.isIForgotMyPasswordButtonClickable(), "\"I forgot my password\" button is not clickable");
        softAssert.assertAll();
    }

    @Test(description = "Test login into account with valid data ")
    @MethodOwner(owner = "Smus Sergii")
    @TestPriority(Priority.P2)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSuccessLoginToAccount() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        TopBar topBar = homePage.getTopBar();
        Assert.assertTrue(topBar.isUIObjectPresent(2), "Top bar wasn't found!");

        LoginPopUp loginPopUp = topBar.getLoginPopUp();

        loginPopUp.typeEmail(TEST_DATA_EMAIL);
        loginPopUp.typePassword(TEST_DATA_PASSWORD);
        LoginPage loginPage = loginPopUp.clickLoginButton();

        Assert.assertTrue(loginPage.isLoginSuccessfulTitleVisible(), "Login is not successful");
    }
}
