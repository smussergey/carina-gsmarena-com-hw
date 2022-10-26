package com.home.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class NewsMobileVersionPage extends AbstractPage {
    private final String newsMobileVersionPageUrl = "https://m.gsmarena.com/news.php3";

    public NewsMobileVersionPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(newsMobileVersionPageUrl);
    }
}