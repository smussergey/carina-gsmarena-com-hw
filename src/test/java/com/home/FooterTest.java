package com.home;

import com.home.gui.components.FooterMenu;
import com.home.gui.pages.*;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FooterTest implements IAbstractTest {

    @Test(description = "Test Footer buttons are present and can open appropriate pages")
    @MethodOwner(owner = "Smus Sergii")
    @TestPriority(Priority.P5)
    @TestLabel(name = "feature", value = {"web", "smoke"})
    public void testFooterButtons() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        FooterMenu footerMenu = homePage.getFooterMenu();
        Assert.assertTrue(footerMenu.isUIObjectPresent(2), "Footer menu wasn't found!");

        homePage.scrollToFooter();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(footerMenu.isNewSButtonPresent(), "News button is not present");
        softAssert.assertTrue(footerMenu.isReviewsButtonPresent(), "Reviews button is not present");
        softAssert.assertTrue(footerMenu.isBlogButtonPresent(), "Blog button is not present");
        softAssert.assertTrue(footerMenu.isPhoneFinderButtonPresent(), "Phone Finder button is not present");
        softAssert.assertTrue(footerMenu.isToolsButtonPresent(), "Tools button is not present");
        softAssert.assertTrue(footerMenu.isCompareButtonPresent(), "Compare button is not present");
        softAssert.assertTrue(footerMenu.isCoverageButtonPresent(), "Coverage button is not present");
        softAssert.assertTrue(footerMenu.isGlossaryButtonPresent(), "Glossary button is not present");
        softAssert.assertTrue(footerMenu.isContactUstButtonPresent(), "Contact Us button is not present");
        softAssert.assertTrue(footerMenu.isGSMArenaComButtonPresent(), "GSMArena.com button is not present");

        NewsPage newsPage = footerMenu.openNewsPage();
        softAssert.assertTrue(newsPage.isPageOpened(), "News page is not opened");
        homePage.open();

        ReviewsPage reviewsPage = footerMenu.openReviewsPage();
        softAssert.assertTrue(reviewsPage.isPageOpened(), "Reviews page is not opened");
        homePage.open();

        BlogPage blogPage = footerMenu.openBlogPage();
        softAssert.assertTrue(blogPage.isPageOpened(), "Blog page is not opened");
        homePage.open();

        PhoneFinderPage phoneFinderPage = footerMenu.openPhoneFinderPage();
        softAssert.assertTrue(phoneFinderPage.isPageOpened(), "Phone Finder page is not opened");
        homePage.open();

        ToolsPage toolsPage = footerMenu.openToolsPage();
        softAssert.assertTrue(toolsPage.isPageOpened(), "Tools page is not opened");
        homePage.open();

        ComparePage comparePage = footerMenu.openComparePage();
        softAssert.assertTrue(comparePage.isPageOpened(), "Compare page is not opened");
        homePage.open();

        CoveragePage coveragePage = footerMenu.openCoveragePage();
        softAssert.assertTrue(coveragePage.isPageOpened(), "Coverage is not opened");
        homePage.open();

        GlossaryPage glossaryPage = footerMenu.openGlossaryPage();
        softAssert.assertTrue(glossaryPage.isPageOpened(), "Glossary is not opened");
        homePage.open();

        ContactPage contactPage = footerMenu.openContactPage();
        softAssert.assertTrue(contactPage.isPageOpened(), "Contact Us page is not opened");
        homePage.open();

        GSMArenaComPage gsmArenaComPage = footerMenu.openGSMArenaComPage();
        softAssert.assertTrue(gsmArenaComPage.isPageOpened(), "GSMArena.com page is not opened");
        homePage.open();

        softAssert.assertAll();

    }
}

