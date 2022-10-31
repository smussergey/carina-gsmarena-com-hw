package com.solvd.gsmarena.gui.pages.othersites;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class TwitterPage extends AbstractPage {
    private final String twitterPageUrl = "https://twitter.com/gsmarena_com";

    public TwitterPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(twitterPageUrl);
    }
}