package ru.ls.qa.school.addressbook.config;

import org.aeonbits.owner.Config;
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:config/${browser}/driver.properties"})
public interface DriverConfig extends Config {
    String browser();
    String browserSize();
    int timeout();
    int pageLoadTimeout();
}
