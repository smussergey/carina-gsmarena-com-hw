package com.solvd.gsmarena.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class ComparePage extends AbstractPage {
    private final String comparePageUrl = "https://www.gsmarena.com/compare.php3";

    public ComparePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(comparePageUrl);
    }
}

