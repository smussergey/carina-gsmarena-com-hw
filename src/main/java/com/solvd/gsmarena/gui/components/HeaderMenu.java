package com.solvd.gsmarena.gui.components;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.gsmarena.gui.enums.HeaderMenuButton;
import com.solvd.gsmarena.gui.factory.PageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractUIObject {
    @FindBy(xpath = "//ul[@id='menu']//a[contains(text(), '%s')]")
    private ExtendedWebElement menuButton;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getMenuButton(HeaderMenuButton button) {
        return menuButton.format(button.getValue());
    }

    public boolean isMenuButtonPresent(HeaderMenuButton button) {
        return menuButton.format(button.getValue()).isPresent();
    }

    public AbstractPage openPage(HeaderMenuButton button) {
        menuButton.format(button.getValue()).click();
        return PageFactory.createPageForHeaderMenuButton(button, driver);
    }

}
