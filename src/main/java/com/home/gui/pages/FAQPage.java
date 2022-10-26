package com.home.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class FAQPage extends AbstractPage {
    private final String faqPageUrl = "https://www.gsmarena.com/faq.php3";

    public FAQPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(faqPageUrl);
    }
}