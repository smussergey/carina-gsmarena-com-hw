package com.solvd.gsmarena.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class RSSFeedPage extends AbstractPage {
    private final String rssFeedPageUrl = "https://www.gsmarena.com/rss-news-reviews.php3";

    public RSSFeedPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(rssFeedPageUrl);
    }
}
