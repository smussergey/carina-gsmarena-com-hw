package com.home.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class TermsOfUsePage extends AbstractPage {
    private final String termsOfUsePageUrl = "https://www.gsmarena.com/terms.php3";

    public TermsOfUsePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(termsOfUsePageUrl);
    }
}