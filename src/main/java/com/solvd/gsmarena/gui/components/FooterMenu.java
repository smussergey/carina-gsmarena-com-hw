package com.solvd.gsmarena.gui.components;

import com.solvd.gsmarena.enums.FooterMenuIButton;
import com.home.gui.pages.*;
import com.home.gui.pages.othersites.*;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.gsmarena.gui.pages.*;
import com.solvd.gsmarena.gui.pages.othersites.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class FooterMenu extends AbstractUIObject {

    @FindBy(xpath = "//div[@id='footer']//a[contains(text(), '%s')]")
    private ExtendedWebElement menuButton;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getMenuButton() { //TODO
        return menuButton;
    }

    public boolean isMenuButtonPresent(FooterMenuIButton button) {
        return menuButton.format(button.getValue()).isPresent();
    }

    public HomePage openHomePage() {
        menuButton.format(FooterMenuIButton.HOME.getValue()).click();
        return new HomePage(driver);
    }

    public NewsPage openNewsPage() {
        menuButton.format(FooterMenuIButton.NEWS.getValue()).click();
        return new NewsPage(driver);
    }

    public ReviewsPage openReviewsPage() {
        menuButton.format(FooterMenuIButton.REVIEWS.getValue()).click();
        return new ReviewsPage(driver);
    }

    public ComparePage openComparePage() {
        menuButton.format(FooterMenuIButton.COMPARE.getValue()).click();
        return new ComparePage(driver);
    }

    public CoveragePage openCoveragePage() {
        menuButton.format(FooterMenuIButton.COVERAGE.getValue()).click();
        return new CoveragePage(driver);
    }

    public GlossaryPage openGlossaryPage() {
        menuButton.format(FooterMenuIButton.GLOSSARY.getValue()).click();
        return new GlossaryPage(driver);
    }

    public FAQPage openFAQPage() {
        menuButton.format(FooterMenuIButton.FAQ.getValue()).click();
        return new FAQPage(driver);
    }

    public RSSFeedPage openRSSFeedPage() {
        menuButton.format(FooterMenuIButton.RSS_FEED.getValue()).click();
        return new RSSFeedPage(driver);
    }

    public YoutubePage openYoutubePage() {
        menuButton.format(FooterMenuIButton.YOUTUBE.getValue()).click();
        return new YoutubePage(driver);
    }

    public FacebookPage openFacebookPage() {
        menuButton.format(FooterMenuIButton.FACEBOOK.getValue()).click();
        return new FacebookPage(driver);
    }

    public TwitterPage openTwitterPage() {
        menuButton.format(FooterMenuIButton.TWITTER.getValue()).click();
        return new TwitterPage(driver);
    }

    public InstagramPage openInstagramPage() {
        menuButton.format(FooterMenuIButton.INSTAGRAM.getValue()).click();
        return new InstagramPage(driver);
    }

    public GSMArenaComPage openGSMArenaComPage() {
        menuButton.format(FooterMenuIButton.GSM_ARENA_COM.getValue()).click();
        return new GSMArenaComPage(driver);
    }

    public HomeMobileVersionPage openHomeMobileVersionPage() {
        menuButton.format(FooterMenuIButton.MOBILE_VERSION.getValue()).click();
        return new HomeMobileVersionPage(driver);
    }

    public AndroidAppPage openAndroidAppPage() {
        menuButton.format(FooterMenuIButton.ANDROID_APP.getValue()).click();
        return new AndroidAppPage(driver);
    }

    public ToolsPage openToolsPage() {
        menuButton.format(FooterMenuIButton.TOOLS.getValue()).click();
        return new ToolsPage(driver);
    }

    public ContactPage openContactPage() {
        menuButton.format(FooterMenuIButton.CONTACT_US.getValue()).click();
        return new ContactPage(driver);
    }

    public MerchPage openMerchStorePage() {
        menuButton.format(FooterMenuIButton.MERCH_STORE.getValue()).click();
        return new MerchPage(driver);
    }

    public PrivacyPage openPrivacyPage() {
        menuButton.format(FooterMenuIButton.PRIVACY.getValue()).click();
        return new PrivacyPage(driver);
    }

    public TermsOfUsePage openTermsOfUsePage() {
        menuButton.format(FooterMenuIButton.TERMS_OF_USE.getValue()).click();
        return new TermsOfUsePage(driver);
    }

}
