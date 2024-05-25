import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import ru.ls.qa.school.addressbook.factory.DataFactory;

public abstract class BaseUiTest {
    protected static final DataFactory dataFactory = new DataFactory();

    @BeforeAll
    public static void setUpBrowser() {
        Configuration.browser = "chrome";
        Configuration.webdriverLogsEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false; // false чтобы видеть как автотесты прогоняются в браузере
    }

    @AfterEach
    public void clear() {
        Selenide.closeWebDriver();
    }
}
