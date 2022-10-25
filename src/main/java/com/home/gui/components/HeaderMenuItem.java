package com.home.gui.components;

public enum HeaderMenuItem {
    HOME("Home"),
    NEWS("News"),
    REVIEWS("Reviews"),
    VIDEOS("Videos"),
    FEATURED("Featured"),
    PHONE_FINDER("Phone Finder"),
    DEALS("Deals"),
    MERCH_NEW("Merch"),
    COVERAGE("Coverage"),
    CONTACT("Contact");

    private final String value;

    HeaderMenuItem(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
