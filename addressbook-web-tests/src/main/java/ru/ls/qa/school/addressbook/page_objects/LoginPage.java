package ru.ls.qa.school.addressbook.page_objects;

import com.codeborne.selenide.As;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import ru.ls.qa.school.addressbook.config.AddressBookConfig;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class LoginPage {
    private static String LOGIN_PAGE_URL = AddressBookConfig.startUrl();
    @As("Поле [Логин]")
    private final SelenideElement fieldLogin
            = $("form input[name=user]");
    @As("Поле [Пароль]")
    private final SelenideElement fieldPassword
            = $("form input[name=pass]");
    @As("Кнопка [Войти]")
    private final SelenideElement buttonLogin
            = $("input[type='submit']");

    public LoginPage() {
        fieldLogin.shouldBe(visible);
        fieldPassword.shouldBe(visible);
        buttonLogin.shouldBe(visible);
    }

    public static LoginPage open() {
        return Selenide.open(LOGIN_PAGE_URL, LoginPage.class);
    }

    public HomePage auth() {
        return auth(AddressBookConfig.login(), AddressBookConfig.password());
    }

    public HomePage auth(String login, String password) {
        return setLogin(login)
                .setPassword(password)
                .clickLoginButtonAndGoToHomePage();
    }

    public final LoginPage setLogin(final String login) {
        fieldLogin.shouldBe(visible)
                  .setValue(login);
        return this;
    }

    public final LoginPage setPassword(final String password) {
        fieldPassword.shouldBe(visible)
                     .setValue(password);
        return this;
    }

    public final HomePage clickLoginButtonAndGoToHomePage() {
        buttonLogin.shouldBe(visible)
                   .click();
        return new HomePage();
    }
}
