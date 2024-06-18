package ru.ls.qa.school.addressbook.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {
    public static AppConfig getAppConfig() {
        return ConfigFactory.create(AppConfig.class);
    }
    public static DriverConfig getDriverConfig() {
        return ConfigFactory.create(DriverConfig.class);
    }
}
