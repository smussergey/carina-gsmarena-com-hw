package com.home.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class BlogPage extends AbstractPage {
    private final String blogPageUrl = "https://www.gsmarena.com/blog.php3";

    public BlogPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(blogPageUrl);
    }
}
