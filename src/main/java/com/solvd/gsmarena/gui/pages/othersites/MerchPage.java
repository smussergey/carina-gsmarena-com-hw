package com.solvd.gsmarena.gui.pages.othersites;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class MerchPage extends AbstractPage {
    private final String merchPageUrl = "https://merch.gsmarena.com/";

    public MerchPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(merchPageUrl);
    }
}

