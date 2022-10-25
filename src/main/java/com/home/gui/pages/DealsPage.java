package com.home.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class DealsPage extends AbstractPage {
    private final String dealsPageUrl = "https://www.gsmarena.com/deals.php3";

    public DealsPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(dealsPageUrl);
    }
}