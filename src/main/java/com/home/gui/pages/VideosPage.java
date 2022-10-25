package com.home.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class VideosPage extends AbstractPage {
    private final String videosPageUrl = "https://www.gsmarena.com/videos.php3";

    public VideosPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(videosPageUrl);
    }
}