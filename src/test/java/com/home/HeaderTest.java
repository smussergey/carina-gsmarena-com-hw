package com.home;

import com.home.gui.components.HeaderMenu;
import com.home.gui.pages.*;
import com.home.gui.pages.other.MerchNewPage;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;

public class HeaderTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "Smus Sergii")
    @TestPriority(Priority.P4)
    @TestLabel(name = "feature", value = {"web", "smoke"})
    public void testHeaderButtonsArePresentAndOpensPages() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.showHeaderMenu();
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        Assert.assertTrue(headerMenu.isUIObjectPresent(2), "Header menu wasn't found!");

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(headerMenu.isHomeButtonPresent(), "Home button is not present");
        softAssert.assertTrue(headerMenu.isNewSButtonPresent(), "News button is not present");
        softAssert.assertTrue(headerMenu.isReviewsButtonPresent(), "Reviews button is not present");
        softAssert.assertTrue(headerMenu.isVideosButtonPresent(), "Videos button is not present");
        softAssert.assertTrue(headerMenu.isFeaturedButtonPresent(), "Featured button is not present");
        softAssert.assertTrue(headerMenu.isPhoneFinderButtonPresent(), "Phone Finder button is not present");
        softAssert.assertTrue(headerMenu.isDealsPresent(), "Deals button is not present");
        softAssert.assertTrue(headerMenu.isMerchNewButtonPresent(), "Merch New button is not present");
        softAssert.assertTrue(headerMenu.isCoverageButtonPresent(), "Coverage button is not present");
        softAssert.assertTrue(headerMenu.isContactButtonPresent(), "Contact button is not present");

        NewsPage newsPage = headerMenu.openNewsPage();
        softAssert.assertTrue(newsPage.isPageOpened(), "News page is not opened");

        ReviewsPage reviewsPage = headerMenu.openReviewsPage();
        softAssert.assertTrue(reviewsPage.isPageOpened(), "Reviews page is not opened");

        VideosPage videosPage = headerMenu.openVideosPage();
        softAssert.assertTrue(videosPage.isPageOpened(), "Videos page is not opened");

        FeaturedPage featuredPage = headerMenu.openFeaturedPage();
        softAssert.assertTrue(featuredPage.isPageOpened(), "Featured page is not opened");

        PhoneFinderPage phoneFinderPage = headerMenu.openPhoneFinderPage();
        softAssert.assertTrue(phoneFinderPage.isPageOpened(), "Phone Finder page is not opened");

        DealsPage dealsPage = headerMenu.openDealsPage();
        softAssert.assertTrue(dealsPage.isPageOpened(), "Deals page is not opened");

        String currentTab = getDriver().getWindowHandle();
        MerchNewPage merchNewPage = headerMenu.openMerchNewPage();
        switchToNewTab(currentTab);
        currentTab = getDriver().getWindowHandle();
        softAssert.assertTrue(merchNewPage.isPageOpened(), "Merch New page is not opened");
        switchToNewTab(currentTab);

        CoveragePage coveragePage = headerMenu.openCoveragePage();
        softAssert.assertTrue(coveragePage.isPageOpened(), "Coverage is not opened");

        ContactPage contactPage = headerMenu.openContactPage();
        softAssert.assertTrue(contactPage.isPageOpened(), "Contact page is not opened");

        homePage = headerMenu.openHomePage();
        softAssert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

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

}
