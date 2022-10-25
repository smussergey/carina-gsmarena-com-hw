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
package com.home.gui.pages;

import com.home.gui.components.FooterMenu;
import com.home.gui.components.HeaderMenu;
import com.home.gui.components.TopBar;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


public class HomePage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'top-bar')]")
    private TopBar topBar;

    @FindBy(id = "menu")
    private HeaderMenu headerMenu;

    @FindBy(id = "footmenu")
    private FooterMenu footerMenu;

    @FindBy(xpath = "//button[@aria-label='Toggle Navigation']")
    private ExtendedWebElement headerMenuButton;

    @FindBy(className = "news-column-index")
    private ExtendedWebElement newsColumn;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(newsColumn);
        setPageAbsoluteURL(R.CONFIG.get(Configuration
                .Parameter.URL.getKey()));
    }

    public TopBar getTopBar() {
        return topBar;
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }


    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    public void showHeaderMenu() {
        headerMenuButton.click();
    }

    public void scrollToFooter() {
        footerMenu.scrollToFooter();
    }
}
