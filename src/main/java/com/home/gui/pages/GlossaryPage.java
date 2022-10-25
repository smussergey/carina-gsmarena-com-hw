package com.home.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class GlossaryPage extends AbstractPage {
    private final String glossaryPageUrl = "https://www.gsmarena.com/glossary.php3";

    public GlossaryPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(glossaryPageUrl);
    }
}

