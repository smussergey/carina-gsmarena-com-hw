package com.home;

import com.home.gui.components.HeaderMenu;
import com.home.gui.components.HeaderMenuButton;
import com.home.gui.pages.*;
import com.home.gui.pages.othersites.MerchPage;
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

public class HeaderTest implements IAbstractTest {

    @Test(description = "Test Header buttons are present and can open appropriate pages")
    @MethodOwner(owner = "Smus Sergii")
    @TestPriority(Priority.P4)
    @TestLabel(name = "feature", value = {"web", "smoke"})
    public void testHeaderButtons() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.showHeaderMenu();
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        Assert.assertTrue(headerMenu.isUIObjectPresent(2), "Header menu wasn't found!");

        SoftAssert softAssert = new SoftAssert();

        Arrays.stream(HeaderMenuButton.values())
                .forEach(button -> softAssert.assertTrue(headerMenu.isButtonPresent(button),
                        String.format("%s button is not present", button)));

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
        MerchPage merchNewPage = headerMenu.openMerchNewPage();
        switchToNewTab(currentTab);
        softAssert.assertTrue(merchNewPage.isPageOpened(), "Merch New page is not opened");
        currentTab = getDriver().getWindowHandle();
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
