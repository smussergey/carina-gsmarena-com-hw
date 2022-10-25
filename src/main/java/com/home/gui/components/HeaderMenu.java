package com.home.gui.components;

import com.home.gui.pages.*;
import com.home.gui.pages.other.MerchNewPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractUIObject {

    @FindBy(xpath = "//ul[@id='menu']//a[contains(text(), '%s')]")
    private ExtendedWebElement linkToPage;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isHomeButtonPresent() {
        return linkToPage.format(HeaderMenuItem.HOME.getValue()).isPresent();
    }

    public boolean isNewSButtonPresent() {
        return linkToPage.format(HeaderMenuItem.NEWS.getValue()).isPresent();
    }

    public boolean isReviewsButtonPresent() {
        return linkToPage.format(HeaderMenuItem.REVIEWS.getValue()).isPresent();
    }

    public boolean isVideosButtonPresent() {
        return linkToPage.format(HeaderMenuItem.VIDEOS.getValue()).isPresent();
    }

    public boolean isFeaturedButtonPresent() {
        return linkToPage.format(HeaderMenuItem.FEATURED.getValue()).isPresent();
    }

    public boolean isPhoneFinderButtonPresent() {
        return linkToPage.format(HeaderMenuItem.PHONE_FINDER.getValue()).isPresent();
    }

    public boolean isDealsPresent() {
        return linkToPage.format(HeaderMenuItem.DEALS.getValue()).isPresent();
    }

    public boolean isMerchNewButtonPresent() {
        return linkToPage.format(HeaderMenuItem.MERCH_NEW.getValue()).isPresent();
    }

    public boolean isCoverageButtonPresent() {
        return linkToPage.format(HeaderMenuItem.COVERAGE.getValue()).isPresent();
    }

    public boolean isContactButtonPresent() {
        return linkToPage.format(HeaderMenuItem.CONTACT.getValue()).isPresent();
    }

    public HomePage openHomePage() {
        linkToPage.format(HeaderMenuItem.HOME.getValue()).click();
        return new HomePage(driver);
    }

    public NewsPage openNewsPage() {
        linkToPage.format(HeaderMenuItem.NEWS.getValue()).click();
        return new NewsPage(driver);
    }

    public ReviewsPage openReviewsPage() {
        linkToPage.format(HeaderMenuItem.REVIEWS.getValue()).click();
        return new ReviewsPage(driver);
    }

    public VideosPage openVideosPage() {
        linkToPage.format(HeaderMenuItem.VIDEOS.getValue()).click();
        return new VideosPage(driver);
    }

    public FeaturedPage openFeaturedPage() {
        linkToPage.format(HeaderMenuItem.FEATURED.getValue()).click();
        return new FeaturedPage(driver);
    }

    public PhoneFinderPage openPhoneFinderPage() {
        linkToPage.format(HeaderMenuItem.PHONE_FINDER.getValue()).click();
        return new PhoneFinderPage(driver);
    }

    public DealsPage openDealsPage() {
        linkToPage.format(HeaderMenuItem.DEALS.getValue()).click();
        return new DealsPage(driver);
    }

    public MerchNewPage openMerchNewPage() {
        linkToPage.format(HeaderMenuItem.MERCH_NEW.getValue()).click();
        return new MerchNewPage(driver);
    }

    public CoveragePage openCoveragePage() {
        linkToPage.format(HeaderMenuItem.COVERAGE.getValue()).click();
        return new CoveragePage(driver);
    }

    public ContactPage openContactPage() {
        linkToPage.format(HeaderMenuItem.CONTACT.getValue()).click();
        return new ContactPage(driver);
    }

}
