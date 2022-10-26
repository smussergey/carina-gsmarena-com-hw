package com.home.gui.pages;

import com.home.gui.components.FooterMenu;
import com.home.gui.components.HeaderMenu;
import com.home.gui.components.TopBar;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'top-bar')]")
    private TopBar topBar;

    @FindBy(id = "menu")
    private HeaderMenu headerMenu;

    @FindBy(id = "footmenu")
    private FooterMenu footerMenu;

    @FindBy(xpath = "//button[@aria-label='Toggle Navigation']")
    private ExtendedWebElement headerMenuButton;

    @FindBy(className = "news-column-index")
    private ExtendedWebElement newsColumn;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(newsColumn);
        setPageAbsoluteURL(R.CONFIG.get(Configuration
                .Parameter.URL.getKey()));
    }

    public TopBar getTopBar() {
        return topBar;
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }


    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    public void showHeaderMenu() {
        headerMenuButton.click();
    }

    public void scrollToFooter() {
        footerMenu.scrollToFooter();
    }
}
