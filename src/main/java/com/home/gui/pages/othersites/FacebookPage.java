package com.home.gui.pages.othersites;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class FacebookPage extends AbstractPage {
    private final String facebookPageUrl = "https://www.facebook.com/people/GSMArenacom/100066846038410/";

    public FacebookPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(facebookPageUrl);
    }
}