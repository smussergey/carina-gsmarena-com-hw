package com.home.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class ReviewsPage extends AbstractPage {
    private final String reviewsPageUrl = "https://www.gsmarena.com/reviews.php3";

    public ReviewsPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(reviewsPageUrl);
    }
}