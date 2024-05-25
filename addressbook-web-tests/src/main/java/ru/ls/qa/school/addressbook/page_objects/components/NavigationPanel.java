package ru.ls.qa.school.addressbook.page_objects.components;

import com.codeborne.selenide.As;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import ru.ls.qa.school.addressbook.page_objects.AddContactPage;
import ru.ls.qa.school.addressbook.page_objects.GroupsPage;
import ru.ls.qa.school.addressbook.page_objects.HomePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class NavigationPanel {
    @As("Кнопка [Home]")
    private final SelenideElement buttonHome = $x("//a[text()='home']");
    @As("Кнопка [Add new]")
    private final SelenideElement buttonAddNew = $x("//a[text()='add new']");
    @As("Кнопка [Groups]")
    private final SelenideElement buttonGroups = $x("//a[text()='groups']");
    @As("Кнопка [Next birthdays]")
    private final SelenideElement buttonNextBirthdays = $x("//a[text()='next birthdays']");

    public NavigationPanel() {
        buttonHome.shouldBe(visible);
        buttonAddNew.shouldBe(visible);
        buttonGroups.shouldBe(visible);
        buttonNextBirthdays.shouldBe(visible);
    }

    public AddContactPage clickButtonAddNew() {
        buttonAddNew.shouldBe(visible)
                    .click();
        return new AddContactPage();
    }

    public HomePage clickButtonHome() {
        buttonHome.shouldBe(visible)
                  .click();
        return new HomePage();
    }

    public GroupsPage clickGroups() {
        buttonGroups.shouldBe(visible)
                    .click();
        return new GroupsPage();
    }
}
