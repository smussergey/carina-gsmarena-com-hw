package com.home.gui.pages;

import com.home.gui.components.FooterMenu;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NewsPage extends AbstractPage {
    private final String newsPageUrl = "https://www.gsmarena.com/news.php3";

    @FindBy(id = "footer")
    private FooterMenu footerMenu;

    public NewsPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(newsPageUrl);
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }
}