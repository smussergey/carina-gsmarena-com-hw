package com.solvd.gsmarena.enums;

public enum HeaderMenuButton {
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

    HeaderMenuButton(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
