package ru.ls.qa.school.addressbook.config;


public class AddressBookConfig {
    private static final AppConfig appConfig = ConfigHelper.getAppConfig();

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
}
