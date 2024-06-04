import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import ru.ls.qa.school.addressbook.config.AddressBookConfig;
import ru.ls.qa.school.addressbook.config.ConfigHelper;
import ru.ls.qa.school.addressbook.config.DriverConfig;
import ru.ls.qa.school.addressbook.factory.DataFactory;

import java.time.Duration;

public abstract class BaseUiTest {
    protected static final DataFactory dataFactory = new DataFactory();

    @BeforeAll
    public static void setUpBrowser() {
        Configuration.browser = AddressBookConfig.browser();
        Configuration.webdriverLogsEnabled = true;
        Configuration.browserSize = AddressBookConfig.browserSize();
        Configuration.headless = false; // false чтобы видеть как автотесты прогоняются в браузере
        Configuration.timeout = Duration.ofSeconds(AddressBookConfig.timeout())
                                        .toMillis();
        Configuration.pageLoadTimeout = AddressBookConfig.pageLoadTimeout();
    }

    @AfterEach
    public void clear() {
        Selenide.closeWebDriver();
    }
}
