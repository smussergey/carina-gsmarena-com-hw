package com.home;

import com.home.gui.components.FooterMenu;
import com.home.gui.components.FooterMenuIButton;
import com.home.gui.pages.*;
import com.home.gui.pages.othersites.*;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.Set;

public class FooterTest implements IAbstractTest {

    @Test(description = "Test Footer buttons are present and can open appropriate pages")
    @MethodOwner(owner = "Smus Sergii")
    @TestPriority(Priority.P5)
    @TestLabel(name = "feature", value = {"web", "smoke"})
    public void testFooterButtons() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        NewsPage newsPage = new NewsPage(getDriver());
        newsPage.open();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened");

        FooterMenu footerMenu = newsPage.getFooterMenu();
        Assert.assertTrue(footerMenu.isUIObjectPresent(2), "Footer menu on News page wasn't found!");
        footerMenu.scrollToFooter();

        SoftAssert softAssert = new SoftAssert();

        Arrays.stream(FooterMenuIButton.values())
                .forEach(button -> softAssert.assertTrue(footerMenu.isButtonPresent(button),
                        String.format("%s button is not present", button)));

        homePage = footerMenu.openHomePage();
        softAssert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        newsPage.open();

        ReviewsPage reviewsPage = footerMenu.openReviewsPage();
        softAssert.assertTrue(reviewsPage.isPageOpened(), "Reviews page is not opened");
        newsPage.open();

        ComparePage comparePage = footerMenu.openComparePage();
        softAssert.assertTrue(comparePage.isPageOpened(), "Compare page is not opened");
        newsPage.open();

        CoveragePage coveragePage = footerMenu.openCoveragePage();
        softAssert.assertTrue(coveragePage.isPageOpened(), "Coverage is not opened");
        newsPage.open();

        GlossaryPage glossaryPage = footerMenu.openGlossaryPage();
        softAssert.assertTrue(glossaryPage.isPageOpened(), "Glossary is not opened");
        newsPage.open();

        FAQPage faqPage = footerMenu.openFAQPage();
        softAssert.assertTrue(faqPage.isPageOpened(), "FAQ is not opened");
        newsPage.open();

        RSSFeedPage rssFeedPage = footerMenu.openRSSFeedPage();
        softAssert.assertTrue(rssFeedPage.isPageOpened(), "RSS feed is not opened");
        newsPage.open();

        String currentTab = getDriver().getWindowHandle();
        YoutubePage youtubePage = footerMenu.openYoutubePage();
        switchToNewTab(currentTab);
        softAssert.assertTrue(youtubePage.isPageOpened(), "Youtube is not opened");
        switchToPreviousTab(currentTab);

        currentTab = getDriver().getWindowHandle();
        FacebookPage facebookPage = footerMenu.openFacebookPage();
        switchToNewTab(currentTab);
        softAssert.assertTrue(facebookPage.isPageOpened(), "Facebook is not opened");
        switchToPreviousTab(currentTab);

        currentTab = getDriver().getWindowHandle();
        TwitterPage twitterPage = footerMenu.openTwitterPage();
        switchToNewTab(currentTab);
        softAssert.assertTrue(twitterPage.isPageOpened(), "Twitter is not opened");
        switchToPreviousTab(currentTab);

        currentTab = getDriver().getWindowHandle();
        InstagramPage instagramPage = footerMenu.openInstagramPage();
        switchToNewTab(currentTab);
        softAssert.assertTrue(instagramPage.isPageOpened(), "Instagram is not opened");
        switchToPreviousTab(currentTab);

        GSMArenaComPage gsmArenaComPage = footerMenu.openGSMArenaComPage();
        softAssert.assertTrue(gsmArenaComPage.isPageOpened(), "GSMArena.com page is not opened");
        newsPage.open();

        NewsMobileVersionPage newsMobileVersionPage = footerMenu.openNewsMobileVersionPage();
        softAssert.assertTrue(newsMobileVersionPage.isPageOpened(), "News Mobile version page is not opened");
        newsPage.open();

        currentTab = getDriver().getWindowHandle();
        AndroidAppPage androidAppPage = footerMenu.openAndroidAppPage();
        switchToNewTab(currentTab);
        softAssert.assertTrue(androidAppPage.isPageOpened(), "Android app page is not opened");
        switchToPreviousTab(currentTab);

        ToolsPage toolsPage = footerMenu.openToolsPage();
        softAssert.assertTrue(toolsPage.isPageOpened(), "Tools page is not opened");
        newsPage.open();

        ContactPage contactPage = footerMenu.openContactPage();
        softAssert.assertTrue(contactPage.isPageOpened(), "Contact Us page is not opened");
        newsPage.open();

        currentTab = getDriver().getWindowHandle();
        MerchPage merchPage = footerMenu.openMerchStorePage();
        switchToNewTab(currentTab);
        softAssert.assertTrue(merchPage.isPageOpened(), "Merch store page is not opened");
        switchToPreviousTab(currentTab);

        PrivacyPage privacyPage = footerMenu.openPrivacyPage();
        softAssert.assertTrue(privacyPage.isPageOpened(), "Privacy page is not opened");
        newsPage.open();

        TermsOfUsePage termsOfUsePage = footerMenu.openTermsOfUsePage();
        softAssert.assertTrue(termsOfUsePage.isPageOpened(), "Terms of use page is not opened");

        newsPage = footerMenu.openNewsPage();
        softAssert.assertTrue(newsPage.isPageOpened(), "News page is not opened");

        softAssert.assertAll();
    }

    private void switchToNewTab(String oldTab) {
        Set<String> tabs = getDriver().getWindowHandles();

        String newTab = tabs.stream()
                .filter(tab -> !tab.equals(oldTab))
                .findFirst()
                .get();

        getDriver().switchTo().window(newTab);
    }

    private void switchToPreviousTab(String currentTab) {
        currentTab = getDriver().getWindowHandle();
        getDriver().close();
        switchToNewTab(currentTab);
    }
}

