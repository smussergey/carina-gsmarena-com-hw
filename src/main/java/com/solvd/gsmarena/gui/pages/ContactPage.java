package com.solvd.gsmarena.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class ContactPage extends AbstractPage {
    private final String contactPageUrl = "https://www.gsmarena.com/contact.php3";

    public ContactPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(contactPageUrl);
    }
}