package com.solvd.gsmarena.gui.pages.othersites;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class AndroidAppPage extends AbstractPage {
    private final String androidAppPageUrl = "https://play.google.com/store/apps/details?id=com.gsmarena.android";

    public AndroidAppPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(androidAppPageUrl);
    }
}