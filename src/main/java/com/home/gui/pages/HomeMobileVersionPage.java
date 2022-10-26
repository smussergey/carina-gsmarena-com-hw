package com.home.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class HomeMobileVersionPage extends AbstractPage {
    private final String newsMobileVersionPageUrl = "https://m.gsmarena.com/";

    public HomeMobileVersionPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(newsMobileVersionPageUrl);
    }
}