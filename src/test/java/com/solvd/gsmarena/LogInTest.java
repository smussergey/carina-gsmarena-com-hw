package com.solvd.gsmarena;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.solvd.gsmarena.gui.components.LoginPopUp;
import com.solvd.gsmarena.gui.components.TopBar;
import com.solvd.gsmarena.gui.pages.HomePage;
import com.solvd.gsmarena.gui.pages.LoginPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogInTest implements IAbstractTest {

    private static final String TEST_DATA_EMAIL = "semtestsem029@gmail.com";
    private static final String TEST_DATA_PASSWORD = "myPassword7";

    @Test(description = "Test presents, intractability of Login popup fields")
    @MethodOwner(owner = "Smus Sergii")
    @TestPriority(Priority.P2)
    @TestLabel(name = "feature", value = {"web", "smoke"})
    public void testFunctionalityOfLogInPopUpFields() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        TopBar topBar = homePage.getTopBar();
        Assert.assertTrue(topBar.isUIObjectPresent(2), "Top bar wasn't found!");

        LoginPopUp popUp = topBar.openLoginPopUp();
        Assert.assertTrue(popUp.isUIObjectPresent(2), "Login pop up wasn't found!");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(popUp.isTitlePresent(), "Title is not present");
        softAssert.assertEquals(popUp.readTitleText(), "Login", "Title does not equal Login");

        softAssert.assertTrue(popUp.isEmailInputTextFieldPresent(), "Email field is not present");
        softAssert.assertTrue(popUp.isEmailInputTextFieldIntractable(TEST_DATA_EMAIL), "We cannot enter text into Email field");

        softAssert.assertTrue(popUp.isPasswordInputTextFieldPresent(), "Password field is not present");
        softAssert.assertTrue(popUp.isPasswordInputTextFieldIntractable(TEST_DATA_PASSWORD), "We cannot enter text into Password field");

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
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSuccessLoginToAccount() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        TopBar topBar = homePage.getTopBar();
        Assert.assertTrue(topBar.isUIObjectPresent(2), "Top bar wasn't found!");

        LoginPopUp popUp = topBar.openLoginPopUp();
        Assert.assertTrue(popUp.isUIObjectPresent(2), "Login pop up wasn't found!");

        popUp.typeEmail(TEST_DATA_EMAIL);
        popUp.typePassword(TEST_DATA_PASSWORD);
        LoginPage loginPage = popUp.clickLoginButton();

        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        Assert.assertTrue(loginPage.isLoginSuccessfulTitleVisible(), "Login is not successful");
    }

    @Test(description = "Test presence of correct error tooltip messages in login fields ",
            dataProvider = "method-data-provider")
    @MethodOwner(owner = "Smus Sergii")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testLoginErrorTooltipMessagesUsingMethodDataProvider(String email, String password, String emailErrorMessage, String passwordErrorMessage, boolean isLoginPageOpened) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        TopBar topBar = homePage.getTopBar();
        Assert.assertTrue(topBar.isUIObjectPresent(2), "Top bar wasn't found!");

        LoginPopUp popUp = topBar.openLoginPopUp();
        Assert.assertTrue(popUp.isUIObjectPresent(2), "Login pop up wasn't found!");

        popUp.typeEmail(email);
        popUp.typePassword(password);
        LoginPage loginPage = popUp.clickLoginButton();

        SoftAssert softAssert = new SoftAssert();
        if (isLoginPageOpened) {
            Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");
            softAssert.assertTrue(loginPage.isLoginFailedTitleVisible(), "Login failed title is not visible");
        } else if (!emailErrorMessage.isEmpty() && !passwordErrorMessage.isEmpty()) {
            softAssert.assertEquals(popUp.getEmailErrorMessage(), emailErrorMessage, "Email Error message is not correct");
        } else {
            softAssert.assertEquals(popUp.getEmailErrorMessage(), emailErrorMessage, "Email Error message is not correct");
            softAssert.assertEquals(popUp.getPasswordErrorMessage(), passwordErrorMessage, "Password Error message is not correct");
        }

        softAssert.assertAll();
    }


    @DataProvider(name = "method-data-provider")
    public Object[][] getTestDataAndErrorMessages() {
        return new Object[][]{
                {"", "", "Please fill out this field.", "Please fill out this field.", false},
                {"wrong@gmail.com", "", "", "Please fill out this field.", false},
                {"", "bcshbcddd", "Please fill out this field.", "", false},
                {"vc55vghfdv@", "efwecwec", String.format("Please enter a part following '@'. '%s' is incomplete.", "vc55vghfdv@"), "", false},
                {"vcvghfcvddvgmail.com", "myPassword7", String.format("Please include an '@' in the email address. '%s' is missing an '@'.", "vcvghfcvddvgmail.com"), "", false},
                {"semtestsem029@gmail.com", "djc", "", "Please match the requested format.", false},
                {"fdssvghfdv@gmail.com", "myPassword7", "", "", true}
        };
    }


    @Test(description = "Test presence of correct error tooltip messages in login fields ",
            dataProvider = "class-data-provider", dataProviderClass = DProvider.class)
    @MethodOwner(owner = "Smus Sergii")
    @TestPriority(Priority.P4)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testLoginErrorTooltipMessagesUsingClassDataProvider(String email, String password, String emailErrorMessage, String passwordErrorMessage, boolean isLoginPageOpened) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        TopBar topBar = homePage.getTopBar();
        Assert.assertTrue(topBar.isUIObjectPresent(2), "Top bar wasn't found!");

        LoginPopUp popUp = topBar.openLoginPopUp();
        Assert.assertTrue(popUp.isUIObjectPresent(2), "Login pop up wasn't found!");

        popUp.typeEmail(email);
        popUp.typePassword(password);
        LoginPage loginPage = popUp.clickLoginButton();

        SoftAssert softAssert = new SoftAssert();
        if (isLoginPageOpened) {
            Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");
            softAssert.assertTrue(loginPage.isLoginFailedTitleVisible(), "Login failed title is not visible");
        } else if (!emailErrorMessage.isEmpty() && !passwordErrorMessage.isEmpty()) {
            softAssert.assertEquals(popUp.getEmailErrorMessage(), emailErrorMessage, "Email Error message is not correct");
        } else {
            softAssert.assertEquals(popUp.getEmailErrorMessage(), emailErrorMessage, "Email Error message is not correct");
            softAssert.assertEquals(popUp.getPasswordErrorMessage(), passwordErrorMessage, "Password Error message is not correct");
        }

        softAssert.assertAll();
    }
}
