package com.solvd.gsmarena.gui.components;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.gsmarena.enums.FooterMenuButton;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.gsmarena.gui.factory.PageFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class FooterMenu extends AbstractUIObject {

    @FindBy(xpath = "//div[@id='footer']//a[contains(text(), '%s')]")
    private ExtendedWebElement menuButton;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getMenuButton(FooterMenuButton button) {
        return menuButton.format(button.getValue());
    }

    public boolean isMenuButtonPresent(FooterMenuButton button) {
        return menuButton.format(button.getValue()).isPresent();
    }

    public AbstractPage openPage(FooterMenuButton button) {
        menuButton.format(button.getValue()).click();
        return PageFactory.createPageForFooterMenuButton(button, driver);
    }

}
