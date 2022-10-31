package com.solvd.gsmarena;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.gsmarena.gui.components.HeaderMenu;
import com.solvd.gsmarena.enums.HeaderMenuButton;
import com.solvd.gsmarena.gui.pages.*;
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

        homePage.clickHeaderNavigationMenuButton();
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        Assert.assertTrue(headerMenu.isUIObjectPresent(2), "Header menu wasn't found!");

        SoftAssert softAssert = new SoftAssert();

        Arrays.stream(HeaderMenuButton.values())
                .forEach(button -> softAssert.assertTrue(headerMenu.isMenuButtonPresent(button),
                        String.format("%s button is not present", button)));

        Arrays.stream(HeaderMenuButton.values())
                .forEach(button -> {
                    if (headerMenu.getMenuButton(button).getElement().getAttribute("target").equals("_blank")) {
                        String currentTab = getDriver().getWindowHandle();
                        AbstractPage page = headerMenu.openPage(button);
                        switchToNewTab(currentTab);
                        softAssert.assertTrue(page.isPageOpened(), String.format("%s page is not opened", button.getValue()));
                        currentTab = getDriver().getWindowHandle();
                        switchToNewTab(currentTab);

                    } else {
                        AbstractPage page = headerMenu.openPage(button);
                        softAssert.assertTrue(page.isPageOpened(), String.format("%s page is not opened", button.getValue()));
                    }
                });

        AbstractPage page = headerMenu.openPage(HeaderMenuButton.HOME);
        softAssert.assertTrue(page.isPageOpened(), String.format("%s page is not opened", HeaderMenuButton.HOME.getValue()));

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
