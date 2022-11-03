package com.solvd.gsmarena.gui.pages;

import com.solvd.gsmarena.gui.enums.FooterMenuButton;
import com.solvd.gsmarena.gui.components.FooterMenu;
import com.solvd.gsmarena.gui.components.HeaderMenu;
import com.solvd.gsmarena.gui.components.TopBar;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final int NUMBER_OF_MILLISECONDS_IN_ONE_SECOND = 1000;

    @FindBy(xpath = "//div[contains(@class, 'top-bar')]")
    private TopBar topBar;

    @FindBy(id = "menu")
    private HeaderMenu headerMenu;

    @FindBy(id = "footer")
    private FooterMenu footerMenu;

    @FindBy(xpath = "//button[@aria-label='Toggle Navigation']")
    private ExtendedWebElement headerNavigationMenuButton;

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

    public void clickHeaderNavigationMenuButton() {
        headerNavigationMenuButton.click();
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    public void scrollToFooter() {
        int explicitTimeOut = Integer.parseInt(R.CONFIG.get(Configuration.Parameter.EXPLICIT_TIMEOUT.getKey()));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        while (footerMenu.getMenuButton(FooterMenuButton.TERMS_OF_USE).getText().length() == 0) {
            ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,document.body.scrollHeight)");
            if ((stopWatch.getTime() / NUMBER_OF_MILLISECONDS_IN_ONE_SECOND) > explicitTimeOut) {
                LOGGER.info("Explicit timeOut was exceeded");
            }
            pause(0.5);
        }

        stopWatch.stop();
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

}
