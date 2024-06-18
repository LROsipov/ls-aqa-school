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
public class GroupPage extends BasePage{
    private final NavigationPanel navigationPanel;
    private final Header header;
    @As("Поле [Group name]")
    private final SelenideElement inputGroupName = $("input[name*=name]");
    @As("Поле [Group header]")
    private final SelenideElement inputGroupHeader = $("textarea[name*=header]");
    @As("Поле [Group footer]")
    private final SelenideElement inputGroupFooter = $("textarea[name*=footer]");
    @As("Кнопка [Enter/Update]")
    private final SelenideElement buttonSubmit = $("input[type=submit]");
    @As("Сообщение успешного добавления")
    private final SelenideElement informationEnteredMessage = $("div[class=msgbox]");
    @As("Кнопка возарата на [Groups page]")
    private final SelenideElement buttonReturnToGroupPage = $("div i a");


    public GroupPage() {
        navigationPanel = new NavigationPanel();
        header = new Header();
        inputGroupName.shouldBe(visible);
        inputGroupHeader.shouldBe(visible);
        inputGroupFooter.shouldBe(visible);
    }

    public GroupPage fillAllFields(GroupModelUi groupModelUi) {
        setValueIntoInput(inputGroupName, groupModelUi.getName());
        setValueIntoInput(inputGroupHeader, groupModelUi.getHeader());
        setValueIntoInput(inputGroupFooter, groupModelUi.getFooter());
        return this;
    }

    public GroupsPage clickButtonSubmitAndGoToGroupPage() {
        buttonSubmit.shouldBe(visible)
                    .click();
        informationEnteredMessage.shouldBe(visible);
        return clickButtonReturnToGroupPage();
    }

    public GroupsPage clickButtonReturnToGroupPage() {
        buttonReturnToGroupPage.click();
        return new GroupsPage();
    }
}
