package com.solvd.gsmarena.gui.pages.othersites;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class YoutubePage extends AbstractPage {
    private final String youtubePageUrl = "https://www.youtube.com/channel/UCbLq9tsbo8peV22VxbDAfXA";

    public YoutubePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(youtubePageUrl);
    }
}