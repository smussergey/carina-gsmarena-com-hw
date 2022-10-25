package com.home.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class FeaturedPage extends AbstractPage {
    private final String featuredPageUrl = "https://www.gsmarena.com/news.php3?sTag=Featured";

    public FeaturedPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(featuredPageUrl);
    }
}