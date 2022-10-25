package com.home.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class NewsPage extends AbstractPage {
    private final String newsPageUrl = "https://www.gsmarena.com/news.php3";

    public NewsPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(newsPageUrl);
    }
}