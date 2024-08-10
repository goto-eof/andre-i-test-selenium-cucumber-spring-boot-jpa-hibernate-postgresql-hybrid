package com.andreidodu.andreitest.util;

import org.openqa.selenium.WebDriver;

public class ThreadContextUtil {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver user) {
        driver.set(user);
    }

    public static void clear() {
        driver.remove();
    }
}