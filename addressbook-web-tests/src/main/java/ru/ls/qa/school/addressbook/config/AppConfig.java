package ru.ls.qa.school.addressbook.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({ "classpath:config/app.properties" })
public interface AppConfig extends Config {
    String startUrl();
    String login();
    String password();
}
