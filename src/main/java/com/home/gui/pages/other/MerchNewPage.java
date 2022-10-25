package com.home.gui.pages.other;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class MerchNewPage extends AbstractPage {
    private final String merchPageUrl = "https://merch.gsmarena.com/";

    public MerchNewPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(merchPageUrl);
    }
}

