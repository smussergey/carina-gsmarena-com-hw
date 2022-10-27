package com.home.gui.components;

import com.home.gui.pages.*;
import com.home.gui.pages.othersites.MerchPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractUIObject {

    @FindBy(xpath = "//ul[@id='menu']//a[contains(text(), '%s')]")
    private ExtendedWebElement menuButton;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isMenuButtonPresent(HeaderMenuButton button) {
        return menuButton.format(button.getValue()).isPresent();
    }

    public HomePage openHomePage() {
        menuButton.format(HeaderMenuButton.HOME.getValue()).click();
        return new HomePage(driver);
    }

    public NewsPage openNewsPage() {
        menuButton.format(HeaderMenuButton.NEWS.getValue()).click();
        return new NewsPage(driver);
    }

    public ReviewsPage openReviewsPage() {
        menuButton.format(HeaderMenuButton.REVIEWS.getValue()).click();
        return new ReviewsPage(driver);
    }

    public VideosPage openVideosPage() {
        menuButton.format(HeaderMenuButton.VIDEOS.getValue()).click();
        return new VideosPage(driver);
    }

    public FeaturedPage openFeaturedPage() {
        menuButton.format(HeaderMenuButton.FEATURED.getValue()).click();
        return new FeaturedPage(driver);
    }

    public PhoneFinderPage openPhoneFinderPage() {
        menuButton.format(HeaderMenuButton.PHONE_FINDER.getValue()).click();
        return new PhoneFinderPage(driver);
    }

    public DealsPage openDealsPage() {
        menuButton.format(HeaderMenuButton.DEALS.getValue()).click();
        return new DealsPage(driver);
    }

    public MerchPage openMerchNewPage() {
        menuButton.format(HeaderMenuButton.MERCH_NEW.getValue()).click();
        return new MerchPage(driver);
    }

    public CoveragePage openCoveragePage() {
        menuButton.format(HeaderMenuButton.COVERAGE.getValue()).click();
        return new CoveragePage(driver);
    }

    public ContactPage openContactPage() {
        menuButton.format(HeaderMenuButton.CONTACT.getValue()).click();
        return new ContactPage(driver);
    }

}
