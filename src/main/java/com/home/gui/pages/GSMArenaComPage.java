package com.home.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class GSMArenaComPage extends AbstractPage {
    private final String gSMArenaComPageUrl = "https://www.gsmarena.com/team.php3";

    public GSMArenaComPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(gSMArenaComPageUrl);
    }
}
