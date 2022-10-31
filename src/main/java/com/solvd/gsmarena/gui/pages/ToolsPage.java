package com.solvd.gsmarena.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class ToolsPage extends AbstractPage {
    private final String toolsPageUrl = "https://www.gsmarena.com/tools.php3";

    public ToolsPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(toolsPageUrl);
    }
}