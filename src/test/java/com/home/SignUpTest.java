package com.home;

import com.home.gui.components.TopBar;
import com.home.gui.pages.HomePage;
import com.home.gui.pages.SignUpPage;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.StringGenerator;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest implements IAbstractTest {

    @Test(description = "Test confirmation registration is shown when registration data is correct")
    @MethodOwner(owner = "Smus Sergii")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "smoke"})
    public void testRegistrationOfNewAccount() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        TopBar topBar = homePage.getTopBar();
        Assert.assertTrue(topBar.isUIObjectPresent(2), "Top bar wasn't found!");

        SignUpPage signUpPage = topBar.openSignUpPage();
        Assert.assertTrue(signUpPage.isPageOpened(), "Sign Up page is not opened!");

        signUpPage.typeNickName(StringGenerator.getUniqueItemName());
        signUpPage.typeEmail(StringGenerator.generateEmail());
        signUpPage.typePassword(StringGenerator.generateWordAN(10));
        signUpPage.checkIAgreeForGSMArenaToStore();
        signUpPage.checkIAmAtLeast16YearsOld();
        signUpPage.clickSubmitButton();

        Assert.assertTrue(signUpPage.isYourAccountWasCreatedTitleVisible(), "Registration is not successful");
    }
}
