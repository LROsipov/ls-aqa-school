package ru.ls.qa.school.addressbook.config;


public class AddressBookConfig {
    private static final AppConfig appConfig = ConfigHelper.getAppConfig();
    private static final DriverConfig driverConfig = ConfigHelper.getDriverConfig();

    private AddressBookConfig() {
    }

    public static String startUrl() {
        return appConfig.startUrl();
    }

    public static String login() {
        return appConfig.login();
    }

    public static String password() {
        return appConfig.password();
    }

    public static String browser() {
        return driverConfig.browser();
    }

    public static String browserSize() {
        return  driverConfig.browserSize();
    }

    public static int timeout() {
        return driverConfig.timeout();
    }

    public static int pageLoadTimeout() {
        return driverConfig.pageLoadTimeout();
    }
}
