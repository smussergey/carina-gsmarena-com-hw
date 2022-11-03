package com.solvd.gsmarena;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.gsmarena.gui.components.FooterMenu;
import com.solvd.gsmarena.gui.enums.FooterMenuButton;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.gsmarena.gui.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.Set;

public class FooterTest implements IAbstractTest {

    @Test(description = "Test Footer menu buttons are present and can open appropriate pages")
    @MethodOwner(owner = "Smus Sergii")
    public void testFooterMenuButtons() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        FooterMenu footerMenu = homePage.getFooterMenu();
        homePage.scrollToFooter();
        Assert.assertTrue(footerMenu.isUIObjectPresent(2), "Footer menu on Home page wasn't found!");

        SoftAssert softAssert = new SoftAssert();

        Arrays.stream(FooterMenuButton.values())
                .forEach(button -> softAssert.assertTrue(footerMenu.isMenuButtonPresent(button),
                        String.format("%s button is not present", button)));

        Arrays.stream(FooterMenuButton.values())
                .forEach(button -> {
                    if (footerMenu.getMenuButton(button).getElement().getAttribute("target").equals("_blank")) {
                        String currentTab = getDriver().getWindowHandle();
                        AbstractPage page = footerMenu.openPage(button);
                        switchToNewTab(currentTab);
                        softAssert.assertTrue(page.isPageOpened(), String.format("%s page is not opened", button.getValue()));
                        switchToPreviousTab(currentTab);
                    } else {
                        AbstractPage page = footerMenu.openPage(button);
                        softAssert.assertTrue(page.isPageOpened(), String.format("%s page is not opened", button.getValue()));
                    }
                    homePage.open();
                    homePage.scrollToFooter();
                });

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

