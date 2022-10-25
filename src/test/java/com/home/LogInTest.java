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

    @Test()
    @MethodOwner(owner = "Smus Sergii")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "smoke"})
    public void testFunctionalityOfLogInPopUpFields() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        TopBar topBar = homePage.getTopBar();
        Assert.assertTrue(topBar.isUIObjectPresent(2), "Top bar wasn't found!");

        LoginPopUp popUp = topBar.getLogInPopUp();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(popUp.isTitlePresent(), "Title is not present");
        softAssert.assertEquals(popUp.readTitleText(), "Login", "Title does not equal Login");

        softAssert.assertTrue(popUp.isEmailInputTextFieldPresent(), "Email field is not present");
        softAssert.assertTrue(popUp.doesEmailInputTextFieldIntractable(), "We cannot enter text into Email field");

        softAssert.assertTrue(popUp.isPasswordInputTextFieldPresent(), "Password field is not present");
        softAssert.assertTrue(popUp.doesPasswordInputTextFieldIntractable(), "We cannot enter text into Password field");

        softAssert.assertTrue(popUp.isLogInButtonPresent(), "Login button is not present");
        popUp.hooverLogInButton();
        softAssert.assertTrue(popUp.getLogInButtonColor().contains("rgb(213, 0, 0)"), "Button has different color");
        softAssert.assertTrue(popUp.isLogInButtonClickable(), "Login button is not clickable");

        softAssert.assertTrue(popUp.isIForgotMyPasswordButtonPresent(), "\"I forgot my password\" button is not present");
        softAssert.assertTrue(popUp.isIForgotMyPasswordButtonClickable(), "\"I forgot my password\" button is not clickable");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "Smus Sergii")
    @TestPriority(Priority.P2)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testConfirmationLoginPageIsOpenedWhenRegistrationDataIsCorrect() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        TopBar topBar = homePage.getTopBar();
        Assert.assertTrue(topBar.isUIObjectPresent(2), "Top bar wasn't found!");

        LoginPopUp loginPopUp = topBar.getLogInPopUp();

        loginPopUp.enterEmail("semtestsem029@gmail.com");
        loginPopUp.enterPassword("myPassword7");
        LoginPage loginPage = loginPopUp.submitForm();

        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");
    }
}
