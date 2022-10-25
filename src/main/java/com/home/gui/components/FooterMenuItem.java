package com.home.gui.components;

public enum FooterMenuItem {
    NEWS("News"),
    REVIEWS("Reviews"),
    BLOG("Blog"),
    PHONE_FINDER("Phone Finder"),
    TOOLS("Tools"),
    COMPARE("Compare"),
    COVERAGE("Coverage"),
    GLOSSARY("Glossary"),
    CONTACT_US("Contact us"),
    GSM_ARENA_COM("GSMArena.com");

    private final String value;

    FooterMenuItem(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

