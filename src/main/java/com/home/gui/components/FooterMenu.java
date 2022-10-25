/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.home.gui.components;

import com.home.gui.pages.*;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FooterMenu extends AbstractUIObject {

    @FindBy(xpath = "//div[@id='footmenu']//a[contains(text(), '%s')]")
    private ExtendedWebElement linkToPage;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isNewSButtonPresent() {
        return linkToPage.format(FooterMenuItem.NEWS.getValue()).isPresent();
    }

    public boolean isReviewsButtonPresent() {
        return linkToPage.format(FooterMenuItem.REVIEWS.getValue()).isPresent();
    }

    public boolean isBlogButtonPresent() {
        return linkToPage.format(FooterMenuItem.BLOG.getValue()).isPresent();
    }

    public boolean isPhoneFinderButtonPresent() {
        return linkToPage.format(FooterMenuItem.PHONE_FINDER.getValue()).isPresent();
    }

    public boolean isToolsButtonPresent() {
        return linkToPage.format(FooterMenuItem.TOOLS.getValue()).isPresent();
    }

    public boolean isCompareButtonPresent() {
        return linkToPage.format(FooterMenuItem.COMPARE.getValue()).isPresent();
    }

    public boolean isCoverageButtonPresent() {
        return linkToPage.format(FooterMenuItem.COVERAGE.getValue()).isPresent();
    }

    public boolean isGlossaryButtonPresent() {
        return linkToPage.format(FooterMenuItem.GLOSSARY.getValue()).isPresent();
    }

    public boolean isContactUstButtonPresent() {
        return linkToPage.format(FooterMenuItem.CONTACT_US.getValue()).isPresent();
    }

    public boolean isGSMArenaComButtonPresent() {
        return linkToPage.format(FooterMenuItem.GSM_ARENA_COM.getValue()).isPresent();
    }

    public NewsPage openNewsPage() {
        linkToPage.format(FooterMenuItem.NEWS.getValue()).click();
        return new NewsPage(driver);
    }

    public ReviewsPage openReviewsPage() {
        linkToPage.format(FooterMenuItem.REVIEWS.getValue()).click();
        return new ReviewsPage(driver);
    }

    public BlogPage openBlogPage() {
        linkToPage.format(FooterMenuItem.BLOG.getValue()).click();
        return new BlogPage(driver);
    }

    public PhoneFinderPage openPhoneFinderPage() {
        linkToPage.format(FooterMenuItem.PHONE_FINDER.getValue()).click();
        return new PhoneFinderPage(driver);
    }

    public ToolsPage openToolsPage() {
        linkToPage.format(FooterMenuItem.TOOLS.getValue()).click();
        return new ToolsPage(driver);
    }

    public ComparePage openComparePage() {
        linkToPage.format(FooterMenuItem.COMPARE.getValue()).click();
        return new ComparePage(driver);
    }

    public CoveragePage openCoveragePage() {
        linkToPage.format(FooterMenuItem.COVERAGE.getValue()).click();
        return new CoveragePage(driver);
    }

    public GlossaryPage openGlossaryPage() {
        linkToPage.format(FooterMenuItem.GLOSSARY.getValue()).click();
        return new GlossaryPage(driver);
    }

    public ContactPage openContactPage() {
        linkToPage.format(FooterMenuItem.CONTACT_US.getValue()).click();
        return new ContactPage(driver);
    }

    public GSMArenaComPage openGSMArenaComPage() {
        linkToPage.format(FooterMenuItem.GSM_ARENA_COM.getValue()).click();
        return new GSMArenaComPage(driver);
    }

    public void scrollToFooter() {
        linkToPage.format(FooterMenuItem.GSM_ARENA_COM.getValue()).scrollTo();
    }

}
