package com.home.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class PhoneFinderPage extends AbstractPage {
    private final String phoneFinderPageUrl = "https://www.gsmarena.com/search.php3?";

    public PhoneFinderPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(phoneFinderPageUrl);
    }
}