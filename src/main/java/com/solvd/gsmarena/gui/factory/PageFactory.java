package com.solvd.gsmarena.gui.factory;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.gsmarena.gui.enums.FooterMenuButton;
import com.solvd.gsmarena.gui.enums.HeaderMenuButton;
import com.solvd.gsmarena.gui.pages.*;
import com.solvd.gsmarena.gui.pages.othersites.*;
import org.openqa.selenium.WebDriver;

public class PageFactory {

    private PageFactory() {
    }

    public static AbstractPage createPageForHeaderMenuButton(HeaderMenuButton button, WebDriver driver) {
        AbstractPage page = null;
        switch (button) {
            case HOME:
                page = new HomePage(driver);
                break;
            case NEWS:
                page = new NewsPage(driver);
                break;
            case REVIEWS:
                page = new ReviewsPage(driver);
                break;
            case VIDEOS:
                page = new VideosPage(driver);
                break;
            case FEATURED:
                page = new FeaturedPage(driver);
                break;
            case PHONE_FINDER:
                page = new PhoneFinderPage(driver);
                break;
            case DEALS:
                page = new DealsPage(driver);
                break;
            case MERCH_NEW:
                page = new MerchPage(driver);
                break;
            case COVERAGE:
                page = new CoveragePage(driver);
                break;
            case CONTACT:
                page = new ContactPage(driver);
                break;
        }
        return page;
    }

    public static AbstractPage createPageForFooterMenuButton(FooterMenuButton button, WebDriver driver) {
        AbstractPage page = null;
        switch (button) {
            case HOME:
                page = new HomePage(driver);
                break;
            case NEWS:
                page = new NewsPage(driver);
                break;
            case REVIEWS:
                page = new ReviewsPage(driver);
                break;
            case COMPARE:
                page = new ComparePage(driver);
                break;
            case COVERAGE:
                page = new CoveragePage(driver);
                break;
            case GLOSSARY:
                page = new GlossaryPage(driver);
                break;
            case FAQ:
                page = new FAQPage(driver);
                break;
            case RSS_FEED:
                page = new RSSFeedPage(driver);
                break;
            case YOUTUBE:
                page = new YoutubePage(driver);
                break;
            case FACEBOOK:
                page = new FacebookPage(driver);
                break;
            case TWITTER:
                page = new TwitterPage(driver);
                break;
            case INSTAGRAM:
                page = new InstagramPage(driver);
                break;
            case GSM_ARENA_COM:
                page = new GSMArenaComPage(driver);
                break;
            case MOBILE_VERSION:
                page = new HomeMobileVersionPage(driver);
                break;
            case ANDROID_APP:
                page = new AndroidAppPage(driver);
                break;
            case TOOLS:
                page = new ToolsPage(driver);
                break;
            case CONTACT_US:
                page = new ContactPage(driver);
                break;
            case MERCH_STORE:
                page = new MerchPage(driver);
                break;
            case PRIVACY:
                page = new PrivacyPage(driver);
                break;
            case TERMS_OF_USE:
                page = new TermsOfUsePage(driver);
                break;
        }
        return page;
    }
}
