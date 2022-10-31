package com.solvd.gsmarena.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class CoveragePage extends AbstractPage {
    private final String coveragePageUrl = "https://www.gsmarena.com/network-bands.php3";

    public CoveragePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(coveragePageUrl);
    }
}
