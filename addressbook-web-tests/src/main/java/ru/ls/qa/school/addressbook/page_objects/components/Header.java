package ru.ls.qa.school.addressbook.page_objects.components;

import com.codeborne.selenide.As;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import ru.ls.qa.school.addressbook.page_objects.LoginPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class Header {
    @As("Кнопка [Logout]")
    private final SelenideElement buttonLogout = $x("//a[text()='Logout']");

    public Header() {
        buttonLogout.shouldBe(visible);
    }

    public LoginPage clickButtonLogout() {
        buttonLogout.shouldBe(visible)
                    .click();
        return new LoginPage();
    }

}
