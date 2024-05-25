package ru.ls.qa.school.addressbook.page_objects;

import com.codeborne.selenide.As;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import ru.ls.qa.school.addressbook.dto.data.GroupModelUi;
import ru.ls.qa.school.addressbook.page_objects.components.Header;
import ru.ls.qa.school.addressbook.page_objects.components.NavigationPanel;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class CreatingGroupPage {
    private final NavigationPanel navigationPanel;
    private final Header header;
    @As("Поле [Group name]")
    private final SelenideElement inputGroupName = $("input[name*=name]");
    @As("Поле [Group header]")
    private final SelenideElement inputGroupHeader = $("textarea[name*=header]");
    @As("Поле [Group footer]")
    private final SelenideElement inputGroupFooter = $("textarea[name*=footer]");
    @As("Кнопка [Enter Information]")
    private final SelenideElement buttonEnterInformation = $("input[name=submit]");
    @As("Сообщение успешного добавления")
    private final SelenideElement informationEnteredMessage = $("div[class=msgbox]");
    @As("Кнопка возарата на [Groups page]")
    private final SelenideElement buttonReturnToGroupPage = $("div i a");


    public CreatingGroupPage() {
        navigationPanel = new NavigationPanel();
        header = new Header();
        inputGroupName.shouldBe(visible);
        inputGroupHeader.shouldBe(visible);
        inputGroupFooter.shouldBe(visible);
        buttonEnterInformation.shouldBe(visible);
    }

    public CreatingGroupPage fillAllFields(GroupModelUi groupModelUi) {
        inputGroupName.shouldBe(visible)
                      .setValue(groupModelUi.getName());
        inputGroupHeader.shouldBe(visible)
                        .setValue(groupModelUi.getHeader());
        inputGroupFooter.shouldBe(visible)
                        .setValue(groupModelUi.getFooter());
        return this;
    }

    public GroupsPage clickButtonEnterInformationAndGoToGroupPage() {
        buttonEnterInformation.shouldBe(visible)
                              .click();
        informationEnteredMessage.shouldBe(visible);
        return clickButtonReturnToGroupPage();
    }

    public GroupsPage clickButtonReturnToGroupPage() {
        buttonReturnToGroupPage.click();
        return new GroupsPage();
    }
}
