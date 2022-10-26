package com.home.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class PrivacyPage extends AbstractPage {
    private final String privacyPageUrl = "https://www.gsmarena.com/privacy-policy.php3";

    public PrivacyPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(privacyPageUrl);
    }
}