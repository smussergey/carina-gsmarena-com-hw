package com.home.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {
    private final String loginPageUrl = "https://www.gsmarena.com/login.php3";

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(loginPageUrl);
    }
}
