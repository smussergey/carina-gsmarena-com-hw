package com.home.gui.pages.othersites;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class InstagramPage extends AbstractPage {
    private final String instagramPageUrl = "https://www.instagram.com/gsmarenateam/";

    public InstagramPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(instagramPageUrl);
    }
}